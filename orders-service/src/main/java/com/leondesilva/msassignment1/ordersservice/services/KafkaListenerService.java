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

/**
 * Class to represent the kafka listener service.
 */
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

    /**
     * Method to listen to order notification topic.
     *
     * @param message the kafka message
     */
    @KafkaListener(topics = "${kafka.order-notifications.topic}", groupId = "${kafka.config.consumer.group-id}")
    public void listenToOrderNotificationsTopic(String message) {
        LOGGER.info("Received kafka message: {}", message);

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

    /**
     * Method to handle order assign notifications.
     *
     * @param orderNotificationEvent the order assign notification to process
     */
    private void handleOrderAssignNotification(OrderNotificationEvent orderNotificationEvent) {
        printNotification("Order id: " + orderNotificationEvent.getOrderId() +
                " has been assigned to service provider id: " + orderNotificationEvent.getServiceProviderId());
        OrderModel order = ordersService.getOrderById(orderNotificationEvent.getOrderId());
        order.setAssignedServiceProviderId(orderNotificationEvent.getServiceProviderId());
        ordersService.updateOrder(order);

        ServiceProviderAssignNotificationEvent serviceProviderAssignNotificationEvent = new ServiceProviderAssignNotificationEvent();
        serviceProviderAssignNotificationEvent.setType("OrderAssignNotification");
        serviceProviderAssignNotificationEvent.setAssignedOrderId(orderNotificationEvent.getOrderId());
        serviceProviderAssignNotificationEvent.setServiceProviderId(order.getAssignedServiceProviderId());

        try {
            kafkaTemplate.send(serviceProviderNotificationsTopic, objectMapper.writeValueAsString(serviceProviderAssignNotificationEvent));
            LOGGER.info("Submitted order assigned message to {} topic", serviceProviderNotificationsTopic);
        } catch (Exception e) {
            LOGGER.error("Error occurred when trying to send data to service provider topic", e);
        }
    }

    /**
     * Method to handle order approve notification.
     *
     * @param orderNotificationEvent the order approve notification to process
     */
    private void handleOrderApproveNotification(OrderNotificationEvent orderNotificationEvent) {
        printNotification("Order id: " + orderNotificationEvent.getOrderId() +
                " has been " + (orderNotificationEvent.isApproved() ? "approved" : "denied") +
                " by service provider id: " + orderNotificationEvent.getServiceProviderInfo().getId());
        OrderModel order = ordersService.getOrderById(orderNotificationEvent.getOrderId());
        order.setApproved(orderNotificationEvent.isApproved());

        if (!orderNotificationEvent.isApproved()) {
            order.setAssignedServiceProviderId(null);
        }

        ordersService.updateOrder(order);

        if (orderNotificationEvent.isApproved()) {
            ConsumerNotificationEvent consumerNotificationEvent = new ConsumerNotificationEvent();
            consumerNotificationEvent.setType("OrderApprovedNotification");
            consumerNotificationEvent.setOrderApproved(true);
            consumerNotificationEvent.setServiceProviderInfo(orderNotificationEvent.getServiceProviderInfo());
            consumerNotificationEvent.setOrderId(orderNotificationEvent.getOrderId());
            consumerNotificationEvent.setOrderDescription(order.getDescription());
            consumerNotificationEvent.setConsumerId(order.getConsumerId());

            try {
                kafkaTemplate.send(consumerNotificationsTopic, objectMapper.writeValueAsString(consumerNotificationEvent));
                LOGGER.info("Submitted order approval message to {} topic", consumerNotificationsTopic);
            } catch (JsonProcessingException e) {
                LOGGER.error("Error occurred when trying to send data to consumer topic", e);
            }
        }
    }

    /**
     * Method to print notifications in console with color.
     *
     * @param notification the notification to print
     */
    private void printNotification(String notification) {
        System.out.println("\033[0;92m[RECEIVED_NOTIFICATION] " + notification);
    }
}
