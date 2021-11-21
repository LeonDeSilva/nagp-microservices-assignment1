package com.leondesilva.msassignment1.ordersservice.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the consumer notification event.
 */
public class ConsumerNotificationEvent {
    private String type;
    private boolean orderApproved;
    private String orderId;
    private String orderDescription;
    private ServiceProviderInfo serviceProviderInfo;
    private String consumerId;

    /**
     * Method to get the event type.
     *
     * @return the event type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set the event type.
     *
     * @param type the event type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to check whether the order is approved.
     *
     * @return true if approved and false if not
     */
    @JsonProperty("orderApproved")
    public boolean isOrderApproved() {
        return orderApproved;
    }

    /**
     * Method to set the order approved status.
     *
     * @param orderApproved true if approved and false if not
     */
    @JsonProperty("orderApproved")
    public void setOrderApproved(boolean orderApproved) {
        this.orderApproved = orderApproved;
    }

    /**
     * Method to get the service provider information.
     *
     * @return the service provider information
     */
    public ServiceProviderInfo getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    /**
     * Method to set the service provider information.
     *
     * @param serviceProviderInfo the service provider information
     */
    public void setServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }

    /**
     * Method to get the order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Method to set the order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
     * Method to get the consumer id.
     *
     * @return the consumer id
     */
    public String getConsumerId() {
        return consumerId;
    }

    /**
     * Method to set the consumer id.
     *
     * @param consumerId the consumer id
     */
    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    /**
     * Method to check equality.
     *
     * @param o the object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumerNotificationEvent that = (ConsumerNotificationEvent) o;

        if (orderApproved != that.orderApproved) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderDescription != null ? !orderDescription.equals(that.orderDescription) : that.orderDescription != null)
            return false;
        if (serviceProviderInfo != null ? !serviceProviderInfo.equals(that.serviceProviderInfo) : that.serviceProviderInfo != null)
            return false;
        return consumerId != null ? consumerId.equals(that.consumerId) : that.consumerId == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderApproved ? 1 : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + (serviceProviderInfo != null ? serviceProviderInfo.hashCode() : 0);
        result = 31 * result + (consumerId != null ? consumerId.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ConsumerNotificationEvent{" +
                "type='" + type + '\'' +
                ", orderApproved=" + orderApproved +
                ", orderId='" + orderId + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", serviceProviderInfo=" + serviceProviderInfo +
                ", consumerId='" + consumerId + '\'' +
                '}';
    }
}
