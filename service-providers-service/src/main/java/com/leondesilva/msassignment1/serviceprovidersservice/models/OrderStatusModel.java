package com.leondesilva.msassignment1.serviceprovidersservice.models;

public class OrderStatusModel {
    private String orderId;
    private boolean isApproved;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatusModel that = (OrderStatusModel) o;

        if (isApproved != that.isApproved) return false;
        return orderId != null ? orderId.equals(that.orderId) : that.orderId == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (isApproved ? 1 : 0);
        return result;
    }
}
