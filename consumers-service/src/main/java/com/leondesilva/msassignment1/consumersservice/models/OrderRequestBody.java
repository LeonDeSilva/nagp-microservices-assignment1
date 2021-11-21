package com.leondesilva.msassignment1.consumersservice.models;

/**
 * Class to represent the order model.
 */
public class OrderRequestBody {
    private String id;
    private String consumerId;
    private String serviceId;
    private String description;

    /**
     * Method to get the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Method to set the id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to get the consumer id.
     *
     * @return the consumer id
     */
    public String getConsumerId() {
        return consumerId;
    }

    /**
     * Method to set the consumer id.
     *
     * @param consumerId the consumer id
     */
    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    /**
     * Method to get the service id.
     *
     * @return the service id
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Method to set the service id.
     *
     * @param serviceId the service id
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        OrderRequestBody that = (OrderRequestBody) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (consumerId != null ? !consumerId.equals(that.consumerId) : that.consumerId != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (consumerId != null ? consumerId.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "OrderRequestBody{" +
                "id='" + id + '\'' +
                ", consumerId='" + consumerId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
