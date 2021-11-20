package com.leondesilva.msassignment1.consumersservice.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leondesilva.msassignment1.consumersservice.models.events.ServiceProviderInfo;

public class ConsumerNotificationEvent {
    private String type;
    private boolean orderApproved;
    private String orderId;
    private String orderDescription;
    private ServiceProviderInfo serviceProviderInfo;
    private String consumerId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("orderApproved")
    public boolean isOrderApproved() {
        return orderApproved;
    }

    @JsonProperty("orderApproved")
    public void setOrderApproved(boolean orderApproved) {
        this.orderApproved = orderApproved;
    }

    public ServiceProviderInfo getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    public void setServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

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
        return serviceProviderInfo != null ? serviceProviderInfo.equals(that.serviceProviderInfo) : that.serviceProviderInfo == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderApproved ? 1 : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + (serviceProviderInfo != null ? serviceProviderInfo.hashCode() : 0);
        return result;
    }
}
