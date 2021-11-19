package com.leondesilva.msassignment1.adminsservice.models;

public class OrderAssignmentModel {
    private String consumerId;
    private String serviceProviderId;
    private String orderDescription;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAssignmentModel that = (OrderAssignmentModel) o;

        if (consumerId != null ? !consumerId.equals(that.consumerId) : that.consumerId != null) return false;
        if (serviceProviderId != null ? !serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId != null) return false;
        return orderDescription != null ? orderDescription.equals(that.orderDescription) : that.orderDescription == null;
    }

    @Override
    public int hashCode() {
        int result = consumerId != null ? consumerId.hashCode() : 0;
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        return result;
    }
}
