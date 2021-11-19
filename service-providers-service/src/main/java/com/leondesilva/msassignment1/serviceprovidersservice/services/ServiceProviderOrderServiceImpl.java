package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.leondesilva.msassignment1.serviceprovidersservice.models.OrderStatusModel;
import org.springframework.stereotype.Service;

/**
 * Implementation of the service provider order service.
 */
@Service
public class ServiceProviderOrderServiceImpl implements ServiceProviderOrderService {
    /**
     * Method to set the status for the service provider's order.
     *
     * @param serviceProviderId the service provider id
     * @param orderStatusModel  the order status information
     */
    @Override
    public void setStatus(String serviceProviderId, OrderStatusModel orderStatusModel) {

    }
}
