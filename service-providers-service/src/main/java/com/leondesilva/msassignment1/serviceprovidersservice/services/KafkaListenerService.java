package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.serviceprovidersservice.models.events.ServiceProviderNotificationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerService.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${kafka.service-provider-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToServiceProviderNotificationsTopic(String message) {
        LOGGER.info("Received kafka message: {}", message);

        try {
            ServiceProviderNotificationEvent event = objectMapper.readValue(message, ServiceProviderNotificationEvent.class);

            if (event.getType().equals("OrderAssignNotification")) {
                printNotification("Order id: " + event.getAssignedOrderId() + " has been assigned to service provider id: " + event.getServiceProviderId());
            } else if (event.getType().equals("DetailedInfoNotification")) {
                printNotification("Detailed information of order id: + " + event.getAssignedOrderId() + ": description: " + event.getOrderDescription() +
                        " consumer information: " + event.getConsumerInfo());
            }

        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred when deserializing event", e);
        }
    }

    private void printNotification(String notification) {
        System.out.println("\033[0;92m[RECEIVED_NOTIFICATION] " + notification);
    }
}
