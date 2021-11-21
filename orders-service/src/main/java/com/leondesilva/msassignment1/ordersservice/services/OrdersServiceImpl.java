package com.leondesilva.msassignment1.ordersservice.services;

import com.leondesilva.msassignment1.ordersservice.models.OrderModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class for the orders service.
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    private static final Map<String, OrderModel> ORDERS_MAP = new HashMap<>();

    /**
     * Method to get all the orders.
     *
     * @return all the orders
     */
    @Override
    public List<OrderModel> getAllOrders() {
        return new ArrayList<>(ORDERS_MAP.values());
    }

    /**
     * Method to get the order by id.
     *
     * @param id the id
     * @return the order information
     */
    @Override
    public OrderModel getOrderById(String id) {
        return  ORDERS_MAP.get(id);
    }

    /**
     * Method to add order information.
     *
     * @param orderModel the order information
     * @return the order information
     */
    @Override
    public OrderModel addOrder(OrderModel orderModel) {
        orderModel.setLastModifiedDateTime(LocalDateTime.now());
        ORDERS_MAP.put(orderModel.getId(), orderModel);
        return ORDERS_MAP.get(orderModel.getId());
    }

    /**
     * Method to update the order information.
     *
     * @param orderModel the order information
     * @return the order information
     */
    @Override
    public OrderModel updateOrder(OrderModel orderModel) {
        orderModel.setLastModifiedDateTime(LocalDateTime.now());
        ORDERS_MAP.put(orderModel.getId(), orderModel);
        return ORDERS_MAP.get(orderModel.getId());
    }

    /**
     * Method to delete the order.
     *
     * @param id the order id to delete
     */
    @Override
    public void deleteOrder(String id) {
        ORDERS_MAP.remove(id);
    }
}
