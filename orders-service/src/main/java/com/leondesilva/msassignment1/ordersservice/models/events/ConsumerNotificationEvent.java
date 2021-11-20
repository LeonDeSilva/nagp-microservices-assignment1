package com.leondesilva.msassignment1.ordersservice.models.events;

public class ConsumerNotificationEvent {
    private String type;
    private boolean orderApproved;
    private ServiceProviderInfo serviceProviderInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOrderApproved() {
        return orderApproved;
    }

    public void setOrderApproved(boolean orderApproved) {
        this.orderApproved = orderApproved;
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

        ConsumerNotificationEvent that = (ConsumerNotificationEvent) o;

        if (orderApproved != that.orderApproved) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return serviceProviderInfo != null ? serviceProviderInfo.equals(that.serviceProviderInfo) : that.serviceProviderInfo == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderApproved ? 1 : 0);
        result = 31 * result + (serviceProviderInfo != null ? serviceProviderInfo.hashCode() : 0);
        return result;
    }
}
