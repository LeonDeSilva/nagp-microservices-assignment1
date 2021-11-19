package com.leondesilva.msassignment1.consumersservice.services;

import com.leondesilva.msassignment1.consumersservice.exceptions.OrderPlacementException;
import com.leondesilva.msassignment1.consumersservice.exceptions.ServiceUriBuilderException;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;
import com.leondesilva.msassignment1.consumersservice.models.OrderRequestBody;
import com.leondesilva.msassignment1.consumersservice.util.ServiceUriBuilder;
import com.netflix.discovery.EurekaClient;
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

    /**
     * Method to place the order.
     *
     * @param consumerId    the consumer id
     * @param consumerOrderModel the consumer order
     * @throws OrderPlacementException if an error occurs at order placement
     */
    @Override
    public void placeOrder(String consumerId, ConsumerOrderModel consumerOrderModel) throws OrderPlacementException {
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
    }
}
