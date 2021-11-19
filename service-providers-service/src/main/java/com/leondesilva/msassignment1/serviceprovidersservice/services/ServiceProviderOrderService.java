package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.leondesilva.msassignment1.serviceprovidersservice.models.OrderStatusModel;

/**
 * Interface for order operations for the service provider
 */
public interface ServiceProviderOrderService {
    /**
     * Method to set the status for the service provider's order.
     *
     * @param serviceProviderId the service provider id
     * @param orderStatusModel the order status information
     */
    void setStatus(String serviceProviderId, OrderStatusModel orderStatusModel);
}
