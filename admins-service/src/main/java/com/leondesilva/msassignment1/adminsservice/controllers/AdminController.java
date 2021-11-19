package com.leondesilva.msassignment1.adminsservice.controllers;

import com.leondesilva.msassignment1.adminsservice.exceptions.InvalidParametersException;
import com.leondesilva.msassignment1.adminsservice.exceptions.OrderAssignmentException;
import com.leondesilva.msassignment1.adminsservice.models.OrderAssignmentModel;
import com.leondesilva.msassignment1.adminsservice.services.OrderAssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private OrderAssignmentService orderAssignmentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/admin/orders")
    public ResponseEntity<Object> assignServiceProviderToOrder(@RequestBody OrderAssignmentModel orderAssignmentModel) {
        try {
            orderAssignmentService.assignOrder(orderAssignmentModel);
        } catch (OrderAssignmentException e) {
            LOGGER.error("Error occurred when trying to assign order.", e);
            return ResponseEntity.internalServerError().build();
        } catch (InvalidParametersException e) {
            LOGGER.error("Error occurred when trying to assign order.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
