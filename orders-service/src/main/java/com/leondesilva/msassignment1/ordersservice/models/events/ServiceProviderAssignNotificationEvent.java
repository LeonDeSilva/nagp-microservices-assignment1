package com.leondesilva.msassignment1.ordersservice.models.events;

public class ServiceProviderAssignNotificationEvent {
    private String serviceProviderId;
    private String type;
    private String assignedOrderId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignedOrderId() {
        return assignedOrderId;
    }

    public void setAssignedOrderId(String assignedOrderId) {
        this.assignedOrderId = assignedOrderId;
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

        ServiceProviderAssignNotificationEvent that = (ServiceProviderAssignNotificationEvent) o;

        if (serviceProviderId != null ? !serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return assignedOrderId != null ? assignedOrderId.equals(that.assignedOrderId) : that.assignedOrderId == null;
    }

    @Override
    public int hashCode() {
        int result = serviceProviderId != null ? serviceProviderId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (assignedOrderId != null ? assignedOrderId.hashCode() : 0);
        return result;
    }
}
