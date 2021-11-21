package com.leondesilva.msassignment1.consumersservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leondesilva.msassignment1.consumersservice.exceptions.OrderPlacementException;
import com.leondesilva.msassignment1.consumersservice.exceptions.ServiceUriBuilderException;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;
import com.leondesilva.msassignment1.consumersservice.models.OrderModel;
import com.leondesilva.msassignment1.consumersservice.models.OrderRequestBody;
import com.leondesilva.msassignment1.consumersservice.util.ServiceUriBuilder;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Service
public class ConsumerOrderPlacementServiceImpl implements ConsumerOrderPlacementService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUserServiceImpl.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServiceUriBuilder serviceUriBuilder;

    @Value("${orders-service.service-name}")
    private String ordersServiceName;

    @Value("${orders-service.orders-post-endpoint.path}")
    private String ordersServicePostEndpointPath;

    @Value("${services-service.service-name}")
    private String servicesServiceName;

    @Value("${services-service.orders-get-endpoint.path}")
    private String servicesGetEndpointPath;

    /**
     * Method to place the order.
     *
     * @param consumerId    the consumer id
     * @param consumerOrderModel the consumer order
     * @return placed order information
     * @throws OrderPlacementException if an error occurs at order placement
     */
    @Override
    public OrderModel placeOrder(String consumerId, ConsumerOrderModel consumerOrderModel) throws OrderPlacementException {
        URI uri = null;

        try {
            uri = serviceUriBuilder.generateUri(ordersServiceName, ordersServicePostEndpointPath);
        } catch (ServiceUriBuilderException e) {
            throw new OrderPlacementException("Error occurred when trying to build the URI", e);
        }

        OrderRequestBody orderRequestBody = new OrderRequestBody();
        orderRequestBody.setId(UUID.randomUUID().toString());
        orderRequestBody.setConsumerId(consumerId);
        orderRequestBody.setServiceId(consumerOrderModel.getServiceId());
        orderRequestBody.setDescription(consumerOrderModel.getDescription());

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, orderRequestBody, String.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new OrderPlacementException("Order service returned status: " + responseEntity.getStatusCode());
        }

        try {
            return objectMapper.readValue(responseEntity.getBody(), OrderModel.class);
        } catch (JsonProcessingException e) {
            throw new OrderPlacementException("Error occurred when trying to deserialize order information", e);
        }
    }

    /**
     * Method to validate the service id of the placed order.
     *
     * @param consumerOrderModel the consumer order model
     * @return true if valid and false if not
     */
    @Override
    public boolean validateServiceIdOfPlacedOrder(ConsumerOrderModel consumerOrderModel) throws OrderPlacementException {
        URI uri = null;

        try {
            uri = serviceUriBuilder.generateUri(servicesServiceName, servicesGetEndpointPath + "/" + consumerOrderModel.getServiceId());

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

            return (responseEntity.getStatusCode() == HttpStatus.OK);

        } catch (ServiceUriBuilderException e) {
            throw new OrderPlacementException("Error occurred when trying to build the URI", e);
        } catch (Exception e) {
            LOGGER.error("Error occurred when trying check for the service", e);
        }

        return false;
    }
}
