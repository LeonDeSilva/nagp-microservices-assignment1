package com.leondesilva.msassignment1.adminsservice.services;

import com.leondesilva.msassignment1.adminsservice.exceptions.InvalidParametersException;
import com.leondesilva.msassignment1.adminsservice.exceptions.OrderAssignmentException;
import com.leondesilva.msassignment1.adminsservice.models.OrderAssignmentModel;

public interface OrderAssignmentService {
    void assignOrder(OrderAssignmentModel orderAssignmentModel) throws OrderAssignmentException, InvalidParametersException;
}
