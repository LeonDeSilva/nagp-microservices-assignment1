package com.leondesilva.msassignment1.serviceprovidersservice.models.events;

/**
 * Class to represent the service provider information.
 */
public class ServiceProviderInfo {
    private String id;
    private String name;
    private String serviceId;
    private String telephone;

    /**
     * Method to get the service provider id.
     *
     * @return the service provider id
     */
    public String getId() {
        return id;
    }

    /**
     * Method to set the service provider id.
     *
     * @param id the service provider id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to get the service provider name.
     *
     * @return the service provider name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the service provider name.
     *
     * @param name the service provider name.
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
     * Method to get the service provider telephone.
     *
     * @return the service provider telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Method to set the service provider telephone.
     *
     * @param telephone the service provider telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

        ServiceProviderInfo that = (ServiceProviderInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        return telephone != null ? telephone.equals(that.telephone) : that.telephone == null;
    }

    /**
     * Method to get the hashcode.
     *
     * @return the hash code
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
     * Method to get the string representation of the object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "ServiceProviderInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
