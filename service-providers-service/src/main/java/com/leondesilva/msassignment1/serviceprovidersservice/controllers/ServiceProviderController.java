package com.leondesilva.msassignment1.serviceprovidersservice.controllers;

import com.leondesilva.msassignment1.serviceprovidersservice.models.ServiceProviderModel;
import com.leondesilva.msassignment1.serviceprovidersservice.services.ServiceProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for service provider.
 */
@RestController
public class ServiceProviderController {
    @Autowired
    private ServiceProvidersService serviceProvidersService;

    /**
     * Method to get all the service providers.
     *
     * @return all the service providers
     */
    @GetMapping("/service-providers")
    public List<ServiceProviderModel> getAllServiceProviders() {
        return serviceProvidersService.getAllServiceProviders();
    }

    /**
     * Method to get the service provider information by id
     *
     * @param id the service provider id
     * @return 200 OK with the service information, 400 Not found if the service provider id was not found
     */
    @GetMapping("/service-providers/{id}")
    public ResponseEntity<Object> getServiceProvider(@PathVariable("id") String id) {
        ServiceProviderModel serviceProvider = serviceProvidersService.getServiceProviderById(id);

        if (serviceProvider != null) {
            return ResponseEntity.ok().body(serviceProvider);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Method to add a new service provider information.
     *
     * @param serviceProviderModel the service provider information
     * @return 200 OK
     */
    @PostMapping("/service-providers")
    public ResponseEntity<Object> addServiceProvider(@RequestBody ServiceProviderModel serviceProviderModel) {
        serviceProvidersService.addServiceProvider(serviceProviderModel);
        return ResponseEntity.ok().build();
    }

    /**
     * Method to update a service provider information.
     *
     * @param serviceProviderModel the service provider information
     * @return 200 OK
     */
    @PutMapping("/service-providers")
    public ResponseEntity<Object> updateService(@RequestBody ServiceProviderModel serviceProviderModel) {
        ServiceProviderModel serviceProvider = serviceProvidersService.getServiceProviderById(serviceProviderModel.getId());

        if (serviceProvider != null) {
            serviceProvidersService.updateServiceProvider(serviceProviderModel);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Controller method to delete an service provider information by id
     *
     * @param id the service provider id
     * @return 200 OK if success, 404 Not found if service provider id was not found
     */
    @DeleteMapping("/service-providers/{id}")
    public ResponseEntity<Object> deleteServiceProvider(@PathVariable("id") String id) {
        ServiceProviderModel serviceProvider = serviceProvidersService.getServiceProviderById(id);

        if (serviceProvider != null) {
            serviceProvidersService.deleteServiceProvider(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
