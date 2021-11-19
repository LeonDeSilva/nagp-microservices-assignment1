package com.leondesilva.msassignment1.consumersservice.services;

import com.leondesilva.msassignment1.consumersservice.models.ConsumerUserModel;

import java.util.List;

/**
 * Interface to represent the consumer user service
 */
public interface ConsumerUserService {
    /**
     * Method to get all the consumer users.
     *
     * @return all the consumer users
     */
    List<ConsumerUserModel> getAllConsumerUsers();

    /**
     * Method to get the consumer user by id.
     *
     * @param id the consumer user id
     * @return the consumer user
     */
    ConsumerUserModel getConsumerUserById(String id);

    /**
     * Method to add a consumer user.
     *
     * @param consumerModel the consumer user to add
     */
    void addConsumerUser(ConsumerUserModel consumerModel);

    /**
     * Method to update the consumer user.
     *
     * @param consumerModel the consumer user to add
     */
    void updateConsumerUser(ConsumerUserModel consumerModel);

    /**
     * Method to delete a consumer user.
     *
     * @param id the consumer user id
     */
    void deleteConsumerUser(String id);
}
