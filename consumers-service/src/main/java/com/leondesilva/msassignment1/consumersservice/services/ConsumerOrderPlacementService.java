package com.leondesilva.msassignment1.consumersservice.services;

import com.leondesilva.msassignment1.consumersservice.exceptions.OrderPlacementException;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;

import java.net.URISyntaxException;

/**
 * Interface to represent the consumer order placement service.
 */
public interface ConsumerOrderPlacementService {
    /**
     * Method to place the order.
     *
     * @param consumerId the consumer id
     * @param consumerOrderModel the consumer order
     * @throws OrderPlacementException if an error occurs at order placement
     */
    void placeOrder(String consumerId, ConsumerOrderModel consumerOrderModel) throws OrderPlacementException;
}
