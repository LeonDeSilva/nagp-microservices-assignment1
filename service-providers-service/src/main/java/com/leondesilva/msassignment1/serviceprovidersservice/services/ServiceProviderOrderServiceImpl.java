package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.serviceprovidersservice.models.OrderStatusModel;
import com.leondesilva.msassignment1.serviceprovidersservice.models.ServiceProviderModel;
import com.leondesilva.msassignment1.serviceprovidersservice.models.events.OrderNotificationEvent;
import com.leondesilva.msassignment1.serviceprovidersservice.models.events.ServiceProviderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Implementation of the service provider order service.
 */
@Service
public class ServiceProviderOrderServiceImpl implements ServiceProviderOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProviderOrderServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.order-notifications.topic}")
    private String orderNotificationTopic;

    @Autowired
    private ServiceProvidersService serviceProvidersService;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Method to set the status for the service provider's order.
     *
     * @param serviceProviderId the service provider id
     * @param orderStatusModel  the order status information
     */
    @Override
    public void setStatus(String serviceProviderId, OrderStatusModel orderStatusModel) {
        ServiceProviderModel serviceProvider = serviceProvidersService.getServiceProviderById(serviceProviderId);

        OrderNotificationEvent event = new OrderNotificationEvent();
        event.setType("OrderApproveNotification");
        event.setApproved(orderStatusModel.isApproved());
        event.setOrderId(orderStatusModel.getOrderId());
        event.setServiceProviderId(serviceProviderId);

        ServiceProviderInfo serviceProviderInfo = new ServiceProviderInfo();
        serviceProviderInfo.setId(serviceProvider.getId());
        serviceProviderInfo.setName(serviceProvider.getName());
        serviceProviderInfo.setServiceId(serviceProvider.getServiceId());
        serviceProviderInfo.setTelephone(serviceProvider.getTelephone());

        event.setServiceProviderInfo(serviceProviderInfo);

        try {
            kafkaTemplate.send(orderNotificationTopic, objectMapper.writeValueAsString(event));
            LOGGER.info("Submitted kafka message for order approval / deny notification. Order id: {}, Service provider: {}, approved: {}", orderStatusModel.getOrderId(), serviceProviderId, orderStatusModel.isApproved());
        } catch (JsonProcessingException e) {
            LOGGER.error("Error occurred when trying to send data to order topic", e);
        }
    }
}
