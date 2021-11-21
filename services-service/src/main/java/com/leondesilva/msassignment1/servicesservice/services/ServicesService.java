package com.leondesilva.msassignment1.servicesservice.services;

import com.leondesilva.msassignment1.servicesservice.models.ServiceModel;

import java.util.List;

/**
 * Interface to represent the services service.
 */
public interface ServicesService {
    /**
     * Method to add a service for the mock DB.
     *
     * @param id          the service id
     * @param serviceName the service name
     * @return the service info
     */
    ServiceModel addService(String id, String serviceName);

    /**
     * Method to get the service by id.
     *
     * @param id the service id
     * @return the service info
     */
    ServiceModel getServiceById(String id);

    /**
     * Method to update the service.
     *
     * @param id   the service id
     * @param name the service name
     * @return the service info
     */
    ServiceModel updateService(String id, String name);

    /**
     * Method to delete service.
     *
     * @param id the service id to delete
     */
    void deleteService(String id);

    /**
     * Method to get all services.
     *
     * @return all the services
     */
    List<ServiceModel> getAllServices();
}
