package com.leondesilva.msassignment1.ordersservice.models.events;

/**
 * Class to represent the service provider assign notification event.
 */
public class ServiceProviderAssignNotificationEvent {
    private String serviceProviderId;
    private String type;
    private String assignedOrderId;

    /**
     * Method to get the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set the type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method to get the assigned order id.
     *
     * @return the assigned order id
     */
    public String getAssignedOrderId() {
        return assignedOrderId;
    }

    /**
     * Method to set the assigned order id.
     *
     * @param assignedOrderId the assigned order id
     */
    public void setAssignedOrderId(String assignedOrderId) {
        this.assignedOrderId = assignedOrderId;
    }

    /**
     * Method to get the service provider id.
     *
     * @return the service provider id
     */
    public String getServiceProviderId() {
        return serviceProviderId;
    }

    /**
     * Method to set the service provider id.
     *
     * @param serviceProviderId the service provider id
     */
    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    /**
     * Method to check equality.
     *
     * @param o the object to compare
     * @return true if equals and false if not
     */
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

    /**
     * Method to get the hashcode.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = serviceProviderId != null ? serviceProviderId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (assignedOrderId != null ? assignedOrderId.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ServiceProviderAssignNotificationEvent{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", type='" + type + '\'' +
                ", assignedOrderId='" + assignedOrderId + '\'' +
                '}';
    }
}
