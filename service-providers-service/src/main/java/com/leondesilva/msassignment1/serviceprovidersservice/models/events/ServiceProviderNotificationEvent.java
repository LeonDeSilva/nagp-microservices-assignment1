package com.leondesilva.msassignment1.serviceprovidersservice.models.events;

import com.leondesilva.msassignment1.serviceprovidersservice.models.ConsumerUserModel;

/**
 * Class to represent the service provider notification event.
 */
public class ServiceProviderNotificationEvent {
    private String serviceProviderId;
    private String type;
    private String assignedOrderId;
    private String orderDescription;
    private ConsumerUserModel consumerInfo;

    /**
     * Method to get the service provider id.
     *
     * @return the service provider id
     */
    public String getServiceProviderId() {
        return serviceProviderId;
    }

    /**
     * Method to set the the service provider id.
     *
     * @param serviceProviderId the service provider id
     */
    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    /**
     * Method to get the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set the type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to get the assigned order id.
     *
     * @return the assigned order id
     */
    public String getAssignedOrderId() {
        return assignedOrderId;
    }

    /**
     * Method to set the assigned order id.
     *
     * @param assignedOrderId the assigned order id
     */
    public void setAssignedOrderId(String assignedOrderId) {
        this.assignedOrderId = assignedOrderId;
    }

    /**
     * Method to get the order description.
     *
     * @return the order description
     */
    public String getOrderDescription() {
        return orderDescription;
    }

    /**
     * Method to set the order description.
     *
     * @param orderDescription the order description
     */
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    /**
     * Method to get the consumer information.
     *
     * @return the consumer information
     */
    public ConsumerUserModel getConsumerInfo() {
        return consumerInfo;
    }

    /**
     * Method to set the consumer information.
     *
     * @param consumerInfo the consumer information
     */
    public void setConsumerInfo(ConsumerUserModel consumerInfo) {
        this.consumerInfo = consumerInfo;
    }

    /**
     * Method to check the equality of the object.
     *
     * @param o the object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceProviderNotificationEvent that = (ServiceProviderNotificationEvent) o;

        if (serviceProviderId != null ? !serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (assignedOrderId != null ? !assignedOrderId.equals(that.assignedOrderId) : that.assignedOrderId != null)
            return false;
        if (orderDescription != null ? !orderDescription.equals(that.orderDescription) : that.orderDescription != null)
            return false;
        return consumerInfo != null ? consumerInfo.equals(that.consumerInfo) : that.consumerInfo == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = serviceProviderId != null ? serviceProviderId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (assignedOrderId != null ? assignedOrderId.hashCode() : 0);
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + (consumerInfo != null ? consumerInfo.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ServiceProviderNotificationEvent{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", type='" + type + '\'' +
                ", assignedOrderId='" + assignedOrderId + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", consumerInfo=" + consumerInfo +
                '}';
    }
}
