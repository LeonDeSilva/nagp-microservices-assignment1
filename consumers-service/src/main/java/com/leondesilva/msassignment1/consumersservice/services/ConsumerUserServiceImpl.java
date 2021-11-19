package com.leondesilva.msassignment1.consumersservice.services;

import com.leondesilva.msassignment1.consumersservice.models.ConsumerUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class of the consumer user service.
 */
@Component
public class ConsumerUserServiceImpl implements ConsumerUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUserServiceImpl.class);
    private static final Map<String, ConsumerUserModel> CONSUMER_USER_MAP = new HashMap<>();

    static {
        ConsumerUserModel consumerUserModel = new ConsumerUserModel();
        consumerUserModel.setId("1");
        consumerUserModel.setName("John");
        consumerUserModel.setEmail("abc@gmail.com");
        consumerUserModel.setTelephone("12345678");
        consumerUserModel.setAddress("address1");
        CONSUMER_USER_MAP.put(consumerUserModel.getId(), consumerUserModel);
    }

    public ConsumerUserServiceImpl() {
        ConsumerUserModel consumerUserModel = CONSUMER_USER_MAP.get("1");
        LOGGER.info("Default User => ID: " + consumerUserModel.getId() + " Name: " +  consumerUserModel.getName());
    }

    /**
     * Method to get all the consumer users.
     *
     * @return all the consumer users
     */
    @Override
    public List<ConsumerUserModel> getAllConsumerUsers() {
        return new ArrayList<>(CONSUMER_USER_MAP.values());
    }

    /**
     * Method to get the consumer user by id.
     *
     * @param id the consumer user id
     * @return the consumer user
     */
    @Override
    public ConsumerUserModel getConsumerUserById(String id) {
        return CONSUMER_USER_MAP.get(id);
    }

    /**
     * Method to add a consumer user.
     *
     * @param consumerModel the consumer user to add
     */
    @Override
    public void addConsumerUser(ConsumerUserModel consumerModel) {
        CONSUMER_USER_MAP.put(consumerModel.getId(), consumerModel);
    }

    /**
     * Method to update the consumer user.
     *
     * @param consumerModel the consumer user to add
     */
    @Override
    public void updateConsumerUser(ConsumerUserModel consumerModel) {
        CONSUMER_USER_MAP.put(consumerModel.getId(), consumerModel);
    }

    /**
     * Method to delete a consumer user.
     *
     * @param id the consumer user id
     */
    @Override
    public void deleteConsumerUser(String id) {
        CONSUMER_USER_MAP.remove(id);
    }
}
