package com.leondesilva.msassignment1.serviceprovidersservice.models;

/**
 * Class to represent the service provider model.
 */
public class ServiceProviderModel {
    private String id;
    private String name;
    private String serviceId;
    private String telephone;

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
     * Method to get the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * Method to get the telephone number.
     *
     * @return the telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Method to set the telephone number.
     *
     * @param telephone the telephone number
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

        ServiceProviderModel that = (ServiceProviderModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        return telephone != null ? telephone.equals(that.telephone) : that.telephone == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }

    /**
     * Method to get the string representation.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ServiceProviderModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
