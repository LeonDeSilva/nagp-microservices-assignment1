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

/**
 * Class to represent the service for kafka listener.
 */
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


    /**
     * Method to list to the order notifications topic.
     *
     * @param message the kafka message
     */
    @KafkaListener(topics = "${kafka.consumer-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToOrderNotificationsTopic(String message) {
        LOGGER.info("Received kafka message: {}", message);

        try {
            ConsumerNotificationEvent consumerNotificationEvent = objectMapper.readValue(message, ConsumerNotificationEvent.class);

            if (consumerNotificationEvent.isOrderApproved()) {
                printNotification("Order id: " + consumerNotificationEvent.getOrderId() +
                        " Placed by consumer id: " + consumerNotificationEvent.getConsumerId() +
                        " has been approved. Service provider info: " + consumerNotificationEvent.getServiceProviderInfo());

                ConsumerUserModel consumer = consumerUserService.getConsumerUserById(consumerNotificationEvent.getConsumerId());

                ServiceProviderNotificationEvent serviceProviderNotificationEvent = new ServiceProviderNotificationEvent();
                serviceProviderNotificationEvent.setServiceProviderId(consumerNotificationEvent.getServiceProviderInfo().getId());
                serviceProviderNotificationEvent.setAssignedOrderId(consumerNotificationEvent.getOrderId());
                serviceProviderNotificationEvent.setOrderDescription(consumerNotificationEvent.getOrderDescription());
                serviceProviderNotificationEvent.setConsumerInfo(consumer);
                serviceProviderNotificationEvent.setType("DetailedInfoNotification");

                kafkaTemplate.send(serviceProviderNotificationsTopic, objectMapper.writeValueAsString(serviceProviderNotificationEvent));
                LOGGER.info("Submitted detailed information to {} topic", serviceProviderNotificationsTopic);
            }

        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred when reading the consumer notification", e);
        }
    }

    /**
     * Method to print the notification with color.
     *
     * @param notification notification to print
     */
    private void printNotification(String notification) {
        System.out.println("\033[0;92m[RECEIVED_NOTIFICATION] " + notification);
    }
}
