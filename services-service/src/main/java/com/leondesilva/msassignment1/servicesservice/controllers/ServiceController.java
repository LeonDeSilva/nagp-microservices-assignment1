package com.leondesilva.msassignment1.servicesservice.controllers;

import com.leondesilva.msassignment1.servicesservice.services.ServicesService;
import com.leondesilva.msassignment1.servicesservice.models.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to represent the service controller
 */
@RestController
public class ServiceController {
    @Autowired
    private ServicesService servicesService;

    /**
     * Method to get all the services.
     *
     * @return all the services
     */
    @GetMapping("/services")
    public List<ServiceModel> getAllServices() {
        return servicesService.getAllServices();
    }

    /**
     * Method to get the service information by id
     *
     * @param id the service id
     * @return 200 OK with the service information, 400 Not found if the service id was not found
     */
    @GetMapping("/services/{id}")
    public ResponseEntity<Object> getService(@PathVariable("id") String id) {
        ServiceModel service = servicesService.getServiceById(id);

        if (service != null) {
            return ResponseEntity.ok().body(service);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Method to add a new service information.
     *
     * @param serviceModel the service information
     * @return 200 OK
     */
    @PostMapping("/services")
    public ResponseEntity<Object> addService(@RequestBody ServiceModel serviceModel) {
        ServiceModel service = servicesService.getServiceById(serviceModel.getId());

        if (service != null) {
            return ResponseEntity.status(403).body("Service already exists");
        }

        ServiceModel serviceModelResult = servicesService.addService(serviceModel.getId(), serviceModel.getName());
        return ResponseEntity.ok().body(serviceModelResult);
    }

    /**
     * Method to update a service information.
     *
     * @param serviceModel the service information
     * @return 200 OK
     */
    @PutMapping("/services")
    public ResponseEntity<Object> updateService(@RequestBody ServiceModel serviceModel) {
        ServiceModel serviceModelResult = servicesService.updateService(serviceModel.getId(), serviceModel.getName());
        return ResponseEntity.ok().body(serviceModelResult);
    }

    /**
     * Controller method to delete a service information by id
     *
     * @param id the service id
     * @return 200 OK if success, 404 Not found if service id was not found
     */
    @DeleteMapping("/services/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable("id") String id) {
        ServiceModel service = servicesService.getServiceById(id);

        if (service != null) {
            servicesService.deleteService(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
