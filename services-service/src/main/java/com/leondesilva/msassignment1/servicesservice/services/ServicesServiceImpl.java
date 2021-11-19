package com.leondesilva.msassignment1.servicesservice.services;

import com.leondesilva.msassignment1.servicesservice.models.ServiceModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class to represent the service service
 */
@Service
public class ServicesServiceImpl implements ServicesService {
    private static final Map<String, ServiceModel> SERVICES_MAP = new HashMap<>();

    static {
        SERVICES_MAP.put("1", new ServiceModel("1", "Electrician"));
        SERVICES_MAP.put("2", new ServiceModel("2", "Plumber"));
        SERVICES_MAP.put("3", new ServiceModel("3", "Yoga Trainer"));
        SERVICES_MAP.put("4", new ServiceModel("4", "Painter"));
    }

    /**
     * Method to add a service for the mock DB.
     *
     * @param id          the service id
     * @param serviceName the service name
     */
    public void addService(String id, String serviceName) {
        SERVICES_MAP.put(id, new ServiceModel(id, serviceName));
    }

    /**
     * Method to get the service by id.
     *
     * @param id the service id
     * @return the service info
     */
    public ServiceModel getServiceById(String id) {
        return SERVICES_MAP.getOrDefault(id, null);
    }

    /**
     * Method to update the service.
     *
     * @param id   the service id
     * @param name the service name
     */
    public void updateService(String id, String name) {
        if (SERVICES_MAP.containsKey(id)) {
            SERVICES_MAP.get(id).setName(name);
        }
    }

    /**
     * Method to delete service.
     *
     * @param id the service id to delete
     */
    public void deleteService(String id) {
        SERVICES_MAP.remove(id);
    }

    /**
     * Method to get all services.
     *
     * @return all the services
     */
    public List<ServiceModel> getAllServices() {
        return new ArrayList<>(SERVICES_MAP.values());
    }
}
