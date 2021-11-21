package com.leondesilva.msassignment1.adminsservice.services;

import com.leondesilva.msassignment1.adminsservice.exceptions.InvalidParametersException;
import com.leondesilva.msassignment1.adminsservice.exceptions.OrderAssignmentException;
import com.leondesilva.msassignment1.adminsservice.models.OrderAssignmentModel;

/**
 * Interface to represent the order assignment service.
 */
public interface OrderAssignmentService {
    /**
     * Method to assign the order to a service provider.
     *
     * @param orderAssignmentModel the order assignment information
     * @throws OrderAssignmentException   if an error occurs at order assignment
     * @throws InvalidParametersException if invalid parameters are provided
     */
    void assignOrder(OrderAssignmentModel orderAssignmentModel) throws OrderAssignmentException, InvalidParametersException;
}
