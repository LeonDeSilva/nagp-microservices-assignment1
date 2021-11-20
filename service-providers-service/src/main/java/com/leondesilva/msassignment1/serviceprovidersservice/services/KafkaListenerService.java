package com.leondesilva.msassignment1.serviceprovidersservice.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {
    @KafkaListener(topics = "${kafka.service-provider-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToServiceProviderNotificationsTopic(String message) {
        printNotification(message);
    }

    private void printNotification(String notification) {
        System.out.println("\033[0;92m[RECEIVED_NOTIFICATION] " + notification);
    }
}
