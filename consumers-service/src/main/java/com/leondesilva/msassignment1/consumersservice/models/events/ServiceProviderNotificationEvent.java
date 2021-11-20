package com.leondesilva.msassignment1.consumersservice.models.events;

import com.leondesilva.msassignment1.consumersservice.models.ConsumerOrderModel;
import com.leondesilva.msassignment1.consumersservice.models.ConsumerUserModel;

public class ServiceProviderNotificationEvent {
    private String type;
    private String orderId;
    private String orderDescription;
    private ConsumerUserModel consumerInfo;

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

    public ConsumerUserModel getConsumerInfo() {
        return consumerInfo;
    }

    public void setConsumerInfo(ConsumerUserModel consumerInfo) {
        this.consumerInfo = consumerInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceProviderNotificationEvent that = (ServiceProviderNotificationEvent) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderDescription != null ? !orderDescription.equals(that.orderDescription) : that.orderDescription != null)
            return false;
        return consumerInfo != null ? consumerInfo.equals(that.consumerInfo) : that.consumerInfo == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderDescription != null ? orderDescription.hashCode() : 0);
        result = 31 * result + (consumerInfo != null ? consumerInfo.hashCode() : 0);
        return result;
    }
}
