package com.leondesilva.msassignment1.adminsservice.models.events;

/**
 * Class to represent the order assign notification event.
 */
public class OrderAssignNotificationEvent {
    private String type = "OrderAssignNotification";
    private String orderId;
    private String serviceProviderId;

    /**
     * Method to get the order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Method to set the order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
     * Method to get the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Method to check equality with another object
     *
     * @param o object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAssignNotificationEvent event = (OrderAssignNotificationEvent) o;

        if (type != null ? !type.equals(event.type) : event.type != null) return false;
        if (orderId != null ? !orderId.equals(event.orderId) : event.orderId != null) return false;
        return serviceProviderId != null ? serviceProviderId.equals(event.serviceProviderId) : event.serviceProviderId == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "OrderAssignNotificationEvent{" +
                "type='" + type + '\'' +
                ", orderId='" + orderId + '\'' +
                ", serviceProviderId='" + serviceProviderId + '\'' +
                '}';
    }
}
