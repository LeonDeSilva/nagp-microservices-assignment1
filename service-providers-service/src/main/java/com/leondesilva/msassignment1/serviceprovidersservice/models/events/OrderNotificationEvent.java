package com.leondesilva.msassignment1.serviceprovidersservice.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderNotificationEvent {
    private String type;
    private String orderId;
    private boolean isApproved;
    private ServiceProviderInfo serviceProviderInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("isApproved")
    public boolean isApproved() {
        return isApproved;
    }

    @JsonProperty("isApproved")
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public ServiceProviderInfo getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    public void setServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderNotificationEvent that = (OrderNotificationEvent) o;

        if (isApproved != that.isApproved) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return serviceProviderInfo != null ? serviceProviderInfo.equals(that.serviceProviderInfo) : that.serviceProviderInfo == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (isApproved ? 1 : 0);
        result = 31 * result + (serviceProviderInfo != null ? serviceProviderInfo.hashCode() : 0);
        return result;
    }
}
