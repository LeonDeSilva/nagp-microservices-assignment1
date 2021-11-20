package com.leondesilva.msassignment1.ordersservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.ordersservice.models.OrderModel;
import com.leondesilva.msassignment1.ordersservice.models.events.ConsumerNotificationEvent;
import com.leondesilva.msassignment1.ordersservice.models.events.OrderNotificationEvent;
import com.leondesilva.msassignment1.ordersservice.models.events.ServiceProviderAssignNotificationEvent;
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
    private OrdersService ordersService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.service-provider-notifications.topic}")
    private String serviceProviderNotificationsTopic;

    @Value("${kafka.consumer-notifications.topic}")
    private String consumerNotificationsTopic;

    @KafkaListener(topics = "${kafka.order-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToOrderNotificationsTopic(String message) {
        System.out.println("Received Message : " + message);
        try {
            OrderNotificationEvent orderNotificationEvent = objectMapper.readValue(message, OrderNotificationEvent.class);

            if (orderNotificationEvent.getType().equals("OrderAssignNotification")) {
                handleOrderAssignNotification(orderNotificationEvent);
            } else if (orderNotificationEvent.getType().equals("OrderApproveNotification")) {
                handleOrderApproveNotification(orderNotificationEvent);
            }

        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred when processing message", e);
        }
    }

    private void handleOrderAssignNotification(OrderNotificationEvent orderNotificationEvent) {
        OrderModel order = ordersService.getOrderById(orderNotificationEvent.getOrderId());
        order.setAssignedServiceProviderId(orderNotificationEvent.getServiceProviderId());
        ordersService.updateOrder(order);

        ServiceProviderAssignNotificationEvent serviceProviderAssignNotificationEvent = new ServiceProviderAssignNotificationEvent();
        serviceProviderAssignNotificationEvent.setType("OrderAssignNotification");
        serviceProviderAssignNotificationEvent.setAssignedOrderId(orderNotificationEvent.getOrderId());
        serviceProviderAssignNotificationEvent.setServiceProviderId(order.getAssignedServiceProviderId());

        try {
            kafkaTemplate.send(serviceProviderNotificationsTopic, objectMapper.writeValueAsString(serviceProviderAssignNotificationEvent));
        } catch (Exception e) {
            LOGGER.error("Error occurred when trying to send data to service provider topic", e);
        }
    }

    private void handleOrderApproveNotification(OrderNotificationEvent orderNotificationEvent) {
        OrderModel order = ordersService.getOrderById(orderNotificationEvent.getOrderId());
        order.setApproved(orderNotificationEvent.isApproved());
        ordersService.updateOrder(order);

        if (orderNotificationEvent.isApproved()) {
            ConsumerNotificationEvent consumerNotificationEvent = new ConsumerNotificationEvent();
            consumerNotificationEvent.setType("OrderApprovedNotification");
            consumerNotificationEvent.setOrderApproved(true);
            consumerNotificationEvent.setServiceProviderInfo(orderNotificationEvent.getServiceProviderInfo());

            try {
                kafkaTemplate.send(consumerNotificationsTopic, objectMapper.writeValueAsString(consumerNotificationEvent));
            } catch (JsonProcessingException e) {
                LOGGER.error("Error occurred when trying to send data to consumer topic", e);
            }
        }
    }
}
