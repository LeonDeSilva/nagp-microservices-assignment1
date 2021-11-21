package com.leondesilva.msassignment1.adminsservice.models;

/**
 * Class to represent the order assignment model.
 */
public class OrderAssignmentModel {
    private String orderId;
    private String serviceProviderId;

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
     * Method to check equality with another object
     *
     * @param o object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAssignmentModel that = (OrderAssignmentModel) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return serviceProviderId != null ? serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "OrderAssignmentModel{" +
                "orderId='" + orderId + '\'' +
                ", serviceProviderId='" + serviceProviderId + '\'' +
                '}';
    }
}
