package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        System.out.println("Received Message : " + message);

    }

}
