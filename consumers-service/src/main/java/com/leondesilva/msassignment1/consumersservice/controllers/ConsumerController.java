package com.leondesilva.msassignment1.consumersservice.controllers;

import com.leondesilva.msassignment1.consumersservice.exceptions.OrderPlacementException;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerUserModel;
import com.leondesilva.msassignment1.consumersservice.models.OrderModel;
import com.leondesilva.msassignment1.consumersservice.services.ConsumerOrderPlacementService;
import com.leondesilva.msassignment1.consumersservice.services.ConsumerUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerUserService consumerUserService;

    @Autowired
    private ConsumerOrderPlacementService consumerOrderPlacementService;

    /**
     * Method to get all the consumers.
     *
     * @return all the consumers
     */
    @GetMapping("/consumers")
    public List<ConsumerUserModel> getAllConsumerUsers() {
        return consumerUserService.getAllConsumerUsers();
    }

    /**
     * Method to get the consumer information by id
     *
     * @param id the consumer id
     * @return 200 OK with the service information, 400 Not found if the consumer id was not found
     */
    @GetMapping("/consumers/{id}")
    public ResponseEntity<Object> getConsumerUser(@PathVariable("id") String id) {
        ConsumerUserModel consumerUser = consumerUserService.getConsumerUserById(id);

        if (consumerUser != null) {
            return ResponseEntity.ok().body(consumerUser);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Method to add a new consumer user information.
     *
     * @param consumerModel the consumer user information
     * @return 200 OK
     */
    @PostMapping("/consumers")
    public ResponseEntity<Object> addConsumerUser(@RequestBody ConsumerUserModel consumerModel) {
        ConsumerUserModel consumerUser = consumerUserService.getConsumerUserById(consumerModel.getId());

        if (consumerUser != null) {
            return ResponseEntity.status(403).body("Consumer already exists");
        }

        ConsumerUserModel consumerUserResult = consumerUserService.addConsumerUser(consumerModel);
        return ResponseEntity.ok().body(consumerUserResult);
    }

    /**
     * Method to update a consumer user information.
     *
     * @param consumerModel the consumer user information
     * @return 200 OK
     */
    @PutMapping("/consumers")
    public ResponseEntity<Object> updateConsumerUser(@RequestBody ConsumerUserModel consumerModel) {
        ConsumerUserModel consumerUserResult = consumerUserService.updateConsumerUser(consumerModel);
        return ResponseEntity.ok().body(consumerUserResult);
    }

    /**
     * Controller method to delete consumer user information by id
     *
     * @param id the consumer id
     * @return 200 OK if success, 404 Not found if consumer id was not found
     */
    @DeleteMapping("/consumers/{id}")
    public ResponseEntity<Object> deleteConsumerUser(@PathVariable("id") String id) {
        ConsumerUserModel consumerUserModel = consumerUserService.getConsumerUserById(id);

        if (consumerUserModel != null) {
            consumerUserService.deleteConsumerUser(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Method to place an order by a consumer.
     *
     * @param id the id
     * @param consumerOrderModel the consumer order
     * @return 200 OK if success, 400 bad request when consumer is invalid
     */
    @PostMapping("/consumers/{id}/orders")
    public ResponseEntity<Object> placeOrder(@PathVariable("id") String id,
                                             @RequestBody ConsumerOrderModel consumerOrderModel) {
        ConsumerUserModel consumerUserModel = consumerUserService.getConsumerUserById(id);

        try {
            if (!consumerOrderPlacementService.validateServiceIdOfPlacedOrder(consumerOrderModel)) {
                return ResponseEntity.badRequest().body("Service id is invalid.");
            }
        } catch (OrderPlacementException e) {
            LOGGER.error("Error occurred when trying to check service validity at place order", e);
        }

        if (consumerUserModel != null) {
            try {
                OrderModel orderModel = consumerOrderPlacementService.placeOrder(id, consumerOrderModel);
                return ResponseEntity.ok().body(orderModel);
            } catch (OrderPlacementException e) {
                LOGGER.error("Error occurred when trying to place order", e);
                return ResponseEntity.internalServerError().build();
            }
        }

        return ResponseEntity.badRequest().body("Consumer id is invalid.");
    }
}
