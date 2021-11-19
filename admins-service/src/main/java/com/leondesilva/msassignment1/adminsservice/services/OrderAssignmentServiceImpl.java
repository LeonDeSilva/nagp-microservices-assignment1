package com.leondesilva.msassignment1.adminsservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.adminsservice.exceptions.InvalidParametersException;
import com.leondesilva.msassignment1.adminsservice.exceptions.OrderAssignmentException;
import com.leondesilva.msassignment1.adminsservice.exceptions.ServiceUriBuilderException;
import com.leondesilva.msassignment1.adminsservice.models.OrderAssignmentModel;
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

    @Value("${consumer-service.service-name}")
    private String consumersServiceName;

    @Value("${consumer-service.consumer-get-endpoint.path}")
    private String consumersGetEndpointPath;

    @Value("${kafka.order-assignment.topic}")
    private String orderAssignmentTopicName;

    @Autowired
    private ServiceUriBuilder serviceUriBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void assignOrder(OrderAssignmentModel orderAssignmentModel) throws OrderAssignmentException, InvalidParametersException {
        validateOrderAssignmentRequest(orderAssignmentModel);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            kafkaTemplate.send(orderAssignmentTopicName, objectMapper.writeValueAsString(orderAssignmentModel));
        } catch (JsonProcessingException e) {
            throw new OrderAssignmentException("Error occurred when sending order assignment event.", e);
        }
    }

    private void validateOrderAssignmentRequest(OrderAssignmentModel orderAssignmentModel) throws InvalidParametersException, OrderAssignmentException {
        if (StringUtils.isEmpty(orderAssignmentModel.getServiceProviderId())) {
            throw new InvalidParametersException("Service id not found");
        }

        if (StringUtils.isEmpty(orderAssignmentModel.getConsumerId())) {
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

        URI consumersUri = null;

        try {
            consumersUri = serviceUriBuilder.generateUri(consumersServiceName, consumersGetEndpointPath + "/" + orderAssignmentModel.getConsumerId());
        } catch (ServiceUriBuilderException e) {
            throw new OrderAssignmentException("Error occurred when generating the URI for consumers get endpoint.", e);
        }

        ResponseEntity<String> consumersResponseEntity = null;

        try {
            consumersResponseEntity = restTemplate.getForEntity(consumersUri, String.class);
        } catch (HttpClientErrorException e) {
            if (e.getRawStatusCode() == 404) {
                throw new InvalidParametersException("consumer id is invalid.", e);
            }

            throw new OrderAssignmentException("Error occurred when trying to connect to consumer service", e);
        }

        if (consumersResponseEntity.getStatusCode() != HttpStatus.OK) {
            throw new InvalidParametersException("Consumer id is invalid.");
        }
    }
}
