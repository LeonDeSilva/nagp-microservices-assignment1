package com.leondesilva.msassignment1.serviceprovidersservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the order status model.
 */
public class OrderStatusModel {
    private String orderId;
    private boolean isApproved;

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
     * Method to check the order approved status.
     *
     * @return true if approved and false if not
     */
    @JsonProperty("isApproved")
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Method to check the order approved status.
     *
     * @param approved true if approved and false if not
     */
    @JsonProperty("isApproved")
    public void setIsApproved(boolean approved) {
        isApproved = approved;
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

        OrderStatusModel that = (OrderStatusModel) o;

        if (isApproved != that.isApproved) return false;
        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (isApproved ? 1 : 0);
        return result;
    }

    /**
     * Method to get the string representation.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "OrderStatusModel{" +
                "orderId='" + orderId + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
