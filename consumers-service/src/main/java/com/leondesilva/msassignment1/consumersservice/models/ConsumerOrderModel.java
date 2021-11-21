package com.leondesilva.msassignment1.consumersservice.models;

/**
 * Class to represent the consumer order model.
 */
public class ConsumerOrderModel {
    private String serviceId;
    private String description;

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

    /**
     * Method to get the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to check the equality of the object.
     *
     * @param o the object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumerOrderModel that = (ConsumerOrderModel) o;

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
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ConsumerOrderModel{" +
                "serviceId='" + serviceId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
