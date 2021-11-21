package com.leondesilva.msassignment1.ordersservice.services;

import com.leondesilva.msassignment1.ordersservice.models.OrderModel;

import java.util.List;

/**
 * Interface for the orders service.
 */
public interface OrdersService {
    /**
     * Method to get all the orders.
     *
     * @return all the orders
     */
    List<OrderModel> getAllOrders();

    /**
     * Method to get the order by id.
     *
     * @param id the id
     * @return the order information
     */
    OrderModel getOrderById(String id);

    /**
     * Method to add order information.
     *
     * @param orderModel the order information
     * @return the order information
     */
    OrderModel addOrder(OrderModel orderModel);

    /**
     * Method to update the order information.
     *
     * @param orderModel the order information
     * @return the order information
     */
    OrderModel updateOrder(OrderModel orderModel);

    /**
     * Method to delete the order.
     *
     * @param id the order id to delete
     */
    void deleteOrder(String id);
}
