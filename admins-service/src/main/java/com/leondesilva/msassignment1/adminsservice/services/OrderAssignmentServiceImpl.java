package com.leondesilva.msassignment1.adminsservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.adminsservice.exceptions.InvalidParametersException;
import com.leondesilva.msassignment1.adminsservice.exceptions.OrderAssignmentException;
import com.leondesilva.msassignment1.adminsservice.exceptions.ServiceUriBuilderException;
import com.leondesilva.msassignment1.adminsservice.models.OrderAssignmentModel;
import com.leondesilva.msassignment1.adminsservice.models.events.OrderAssignNotificationEvent;
import com.leondesilva.msassignment1.adminsservice.util.ServiceUriBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class OrderAssignmentServiceImpl implements OrderAssignmentService {
    @Value("${service-providers-service.service-name}")
    private String serviceProvidersServiceName;

    @Value("${service-providers-service-get-endpoint.path}")
    private String serviceProvidersGetEndpointPath;

    @Value("${order-service.service-name}")
    private String ordersServiceName;

    @Value("${order-service.order-get-endpoint.path}")
    private String ordersGetEndpointPath;

    @Value("${kafka.order-notifications.topic}")
    private String orderNotificationsTopic;

    @Autowired
    private ServiceUriBuilder serviceUriBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void assignOrder(OrderAssignmentModel orderAssignmentModel) throws OrderAssignmentException, InvalidParametersException {
        OrderAssignNotificationEvent event = new OrderAssignNotificationEvent();
        event.setOrderId(orderAssignmentModel.getOrderId());
        event.setServiceProviderId(orderAssignmentModel.getServiceProviderId());

        validateOrderAssignmentRequest(orderAssignmentModel);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            kafkaTemplate.send(orderNotificationsTopic, objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            throw new OrderAssignmentException("Error occurred when sending order assignment event.", e);
        }
    }

    private void validateOrderAssignmentRequest(OrderAssignmentModel orderAssignmentModel) throws InvalidParametersException, OrderAssignmentException {
        if (StringUtils.isEmpty(orderAssignmentModel.getServiceProviderId())) {
            throw new InvalidParametersException("Service id not found");
        }

        if (StringUtils.isEmpty(orderAssignmentModel.getOrderId())) {
            throw new InvalidParametersException("Consumer id not found");
        }

        URI serviceUri = null;

        try {
            serviceUri = serviceUriBuilder.generateUri(serviceProvidersServiceName, serviceProvidersGetEndpointPath + "/" + orderAssignmentModel.getServiceProviderId());
        } catch (ServiceUriBuilderException e) {
            throw new OrderAssignmentException("Error occurred when generating the URI for services get endpoint.", e);
        }

        ResponseEntity<String> servicesResponseEntity = null;

        try {
            servicesResponseEntity = restTemplate.getForEntity(serviceUri, String.class);
        } catch (HttpClientErrorException e) {
            if (e.getRawStatusCode() == 404) {
                throw new InvalidParametersException("Service provider id is invalid.", e);
            }

            throw new OrderAssignmentException("Error occurred when trying to connect to service provider service", e);
        }

        if (servicesResponseEntity.getStatusCode() != HttpStatus.OK) {
            throw new InvalidParametersException("Service id is invalid.");
        }

        URI ordersUri = null;

        try {
            ordersUri = serviceUriBuilder.generateUri(ordersServiceName, ordersGetEndpointPath + "/" + orderAssignmentModel.getOrderId());
        } catch (ServiceUriBuilderException e) {
            throw new OrderAssignmentException("Error occurred when generating the URI for orders get endpoint.", e);
        }

        ResponseEntity<String> ordersResponseEntity = null;

        try {
            ordersResponseEntity = restTemplate.getForEntity(ordersUri, String.class);
        } catch (HttpClientErrorException e) {
            if (e.getRawStatusCode() == 404) {
                throw new InvalidParametersException("Order id is invalid.", e);
            }

            throw new OrderAssignmentException("Error occurred when trying to connect to order service", e);
        }

        if (ordersResponseEntity.getStatusCode() != HttpStatus.OK) {
            throw new InvalidParametersException("Order id is invalid.");
        }
    }
}
