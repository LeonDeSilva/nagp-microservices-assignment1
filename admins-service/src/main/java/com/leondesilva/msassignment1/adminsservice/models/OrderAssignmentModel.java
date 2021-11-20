package com.leondesilva.msassignment1.adminsservice.models;

public class OrderAssignmentModel {
    private String orderId;
    private String serviceProviderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAssignmentModel that = (OrderAssignmentModel) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return serviceProviderId != null ? serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return result;
    }
}