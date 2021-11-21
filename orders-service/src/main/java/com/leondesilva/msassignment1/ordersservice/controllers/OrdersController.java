package com.leondesilva.msassignment1.ordersservice.controllers;

import com.leondesilva.msassignment1.ordersservice.models.OrderModel;
import com.leondesilva.msassignment1.ordersservice.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to represent the order controller
 */
@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * Method to get all the orders.
     *
     * @return all the orders
     */
    @GetMapping("/orders")
    public List<OrderModel> getAllOrders() {
        return ordersService.getAllOrders();
    }

    /**
     * Method to get the order information by id
     *
     * @param id the order id
     * @return 200 OK with the order information, 400 Not found if the order id was not found
     */
    @GetMapping("/orders/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") String id) {
        OrderModel order = ordersService.getOrderById(id);

        if (order != null) {
            return ResponseEntity.ok().body(order);
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Method to add a new order information.
     *
     * @param orderModel the order information
     * @return 200 OK
     */
    @PostMapping("/orders")
    public ResponseEntity<Object> addOrder(@RequestBody OrderModel orderModel) {
        OrderModel order = ordersService.getOrderById(orderModel.getId());

        if (order != null) {
            return ResponseEntity.status(403).body("Order already exists");
        }

        OrderModel orderModelResult = ordersService.addOrder(orderModel);
        return ResponseEntity.ok().body(orderModelResult);
    }

    /**
     * Method to update a order information.
     *
     * @param orderModel the order information
     * @return 200 OK
     */
    @PutMapping("/orders")
    public ResponseEntity<Object> updateService(@RequestBody OrderModel orderModel) {
        OrderModel orderModelResult = ordersService.updateOrder(orderModel);
        return ResponseEntity.ok().body(orderModelResult);
    }

    /**
     * Controller method to delete an order information by id
     *
     * @param id the order id
     * @return 200 OK if success, 404 Not found if order id was not found
     */
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") String id) {
        OrderModel order = ordersService.getOrderById(id);

        if (order != null) {
            ordersService.deleteOrder(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
