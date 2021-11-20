package com.leondesilva.msassignment1.consumersservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.leondesilva.msassignment1.consumersservice.models.ConsumerUserModel;
import com.leondesilva.msassignment1.consumersservice.models.events.ConsumerNotificationEvent;
import com.leondesilva.msassignment1.consumersservice.models.events.ServiceProviderNotificationEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerService.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ConsumerUserService consumerUserService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.service-provider-notifications.topic}")
    private String serviceProviderNotificationsTopic;


    @KafkaListener(topics = "${kafka.consumer-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToOrderNotificationsTopic(String message) {
        System.out.println("Received Message : " + message);

        try {
            ConsumerNotificationEvent consumerNotificationEvent = objectMapper.readValue(message, ConsumerNotificationEvent.class);

            if (consumerNotificationEvent.isOrderApproved()) {
                ConsumerUserModel consumer = consumerUserService.getConsumerUserById(consumerNotificationEvent.getConsumerId());

                ServiceProviderNotificationEvent serviceProviderNotificationEvent = new ServiceProviderNotificationEvent();
                serviceProviderNotificationEvent.setOrderId(consumerNotificationEvent.getOrderId());
                serviceProviderNotificationEvent.setOrderDescription(consumerNotificationEvent.getOrderDescription());
                serviceProviderNotificationEvent.setConsumerInfo(consumer);
                serviceProviderNotificationEvent.setType("DetailedInfo");

                kafkaTemplate.send(serviceProviderNotificationsTopic, objectMapper.writeValueAsString(serviceProviderNotificationEvent));
            }

        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred when reading the consumer notification", e);
        }
    }


}
