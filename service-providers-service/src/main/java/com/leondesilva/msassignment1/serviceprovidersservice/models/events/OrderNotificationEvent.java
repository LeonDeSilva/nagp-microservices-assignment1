package com.leondesilva.msassignment1.serviceprovidersservice.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the order notification event.
 */
public class OrderNotificationEvent {
    private String type;
    private String orderId;
    private String serviceProviderId;
    private boolean isApproved;
    private ServiceProviderInfo serviceProviderInfo;

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
     * Method to get the service provider id.
     *
     * @return the service provider id
     */
    public String getServiceProviderId() {
        return serviceProviderId;
    }

    /**
     * Method to set the service provider id.
     *
     * @param serviceProviderId the service provider id
     */
    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    /**
     * Method to check whether the order is approved.
     *
     * @return true if approved and false if not
     */
    @JsonProperty("isApproved")
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Method to set the approved status.
     *
     * @param approved true if approved and false if not
     */
    @JsonProperty("isApproved")
    public void setApproved(boolean approved) {
        isApproved = approved;
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
     * Method to check equality.
     *
     * @param o the object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderNotificationEvent that = (OrderNotificationEvent) o;

        if (isApproved != that.isApproved) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (serviceProviderId != null ? !serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId != null)
            return false;
        return serviceProviderInfo != null ? serviceProviderInfo.equals(that.serviceProviderInfo) : that.serviceProviderInfo == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        result = 31 * result + (isApproved ? 1 : 0);
        result = 31 * result + (serviceProviderInfo != null ? serviceProviderInfo.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "OrderNotificationEvent{" +
                "type='" + type + '\'' +
                ", orderId='" + orderId + '\'' +
                ", serviceProviderId='" + serviceProviderId + '\'' +
                ", isApproved=" + isApproved +
                ", serviceProviderInfo=" + serviceProviderInfo +
                '}';
    }
}
