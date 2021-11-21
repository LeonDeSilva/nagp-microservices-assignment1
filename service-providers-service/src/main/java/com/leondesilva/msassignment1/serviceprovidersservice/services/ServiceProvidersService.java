package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.leondesilva.msassignment1.serviceprovidersservice.models.ServiceProviderModel;

import java.util.List;

/**
 * Interface to represent the service provider service.
 */
public interface ServiceProvidersService {
    /**
     * Method to get all the service providers.
     *
     * @return all the service providers
     */
    List<ServiceProviderModel> getAllServiceProviders();

    /**
     * Method to get the service provider by id.
     *
     * @param id the service provider id
     * @return the service provider information
     */
    ServiceProviderModel getServiceProviderById(String id);

    /**
     * Method to add service provider information.
     *
     * @param serviceProviderModel the service provider information
     * @return the service provider information
     */
    ServiceProviderModel addServiceProvider(ServiceProviderModel serviceProviderModel);

    /**
     * Method to update the service provider information.
     *
     * @param serviceProviderModel the service provider information
     * @return the service provider information
     */
    ServiceProviderModel updateServiceProvider(ServiceProviderModel serviceProviderModel);

    /**
     * Method to delete the service provider.
     *
     * @param id the service provider id
     */
    void deleteServiceProvider(String id);
}
