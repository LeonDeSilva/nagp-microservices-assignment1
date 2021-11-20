package com.leondesilva.msassignment1.adminsservice.models.events;

public class OrderAssignNotificationEvent {
    private String type = "OrderAssignNotification";
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

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAssignNotificationEvent event = (OrderAssignNotificationEvent) o;

        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (orderId != null ? !orderId.equals(event.orderId) : event.orderId != null) return false;
        return serviceProviderId != null ? serviceProviderId.equals(event.serviceProviderId) : event.serviceProviderId == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return result;
    }
}
