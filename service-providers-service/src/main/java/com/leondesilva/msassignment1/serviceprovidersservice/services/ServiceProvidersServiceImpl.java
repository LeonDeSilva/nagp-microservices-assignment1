package com.leondesilva.msassignment1.serviceprovidersservice.services;

import com.leondesilva.msassignment1.serviceprovidersservice.models.ServiceProviderModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class of the service provider service.
 */
@Service
public class ServiceProvidersServiceImpl implements ServiceProvidersService {
    private static final Map<String, ServiceProviderModel> SERVICE_PROVIDER_MAP = new HashMap<>();

    /**
     * Method to get all the service providers.
     *
     * @return all the service providers
     */
    @Override
    public List<ServiceProviderModel> getAllServiceProviders() {
        return new ArrayList<>(SERVICE_PROVIDER_MAP.values());
    }

    /**
     * Method to get the service provider by id.
     *
     * @param id the service provider id
     * @return the service provider information
     */
    @Override
    public ServiceProviderModel getServiceProviderById(String id) {
        return SERVICE_PROVIDER_MAP.get(id);
    }

    /**
     * Method to add service provider information.
     *
     * @param serviceProviderModel the service provider information
     */
    @Override
    public void addServiceProvider(ServiceProviderModel serviceProviderModel) {
        SERVICE_PROVIDER_MAP.put(serviceProviderModel.getId(), serviceProviderModel);
    }

    /**
     * Method to update the service provider information.
     *
     * @param serviceProviderModel the service provider information
     */
    @Override
    public void updateServiceProvider(ServiceProviderModel serviceProviderModel) {
        SERVICE_PROVIDER_MAP.put(serviceProviderModel.getId(), serviceProviderModel);
    }

    /**
     * Method to delete the service provider.
     *
     * @param id the service provider id
     */
    @Override
    public void deleteServiceProvider(String id) {
        SERVICE_PROVIDER_MAP.remove(id);
    }
}
