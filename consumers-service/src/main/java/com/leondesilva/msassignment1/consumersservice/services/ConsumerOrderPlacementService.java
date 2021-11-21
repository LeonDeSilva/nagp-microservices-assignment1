package com.leondesilva.msassignment1.consumersservice.services;

import com.leondesilva.msassignment1.consumersservice.exceptions.OrderPlacementException;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;
import com.leondesilva.msassignment1.consumersservice.models.OrderModel;

/**
 * Interface to represent the consumer order placement service.
 */
public interface ConsumerOrderPlacementService {
    /**
     * Method to place the order.
     *
     * @param consumerId         the consumer id
     * @param consumerOrderModel the consumer order
     * @return placed order information
     * @throws OrderPlacementException if an error occurs at order placement
     */
    OrderModel placeOrder(String consumerId, ConsumerOrderModel consumerOrderModel) throws OrderPlacementException;

    /**
     * Method to validate the service id of the placed order.
     *
     * @param consumerOrderModel the consumer order model
     * @return true if valid and false if not
     * @throws OrderPlacementException if an error occurs at order placement parameter validations
     */
    boolean validateServiceIdOfPlacedOrder(ConsumerOrderModel consumerOrderModel) throws OrderPlacementException;
}
