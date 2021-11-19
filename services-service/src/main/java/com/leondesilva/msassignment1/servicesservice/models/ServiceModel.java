package com.leondesilva.msassignment1.servicesservice.models;

/**
 * Class to represent the service model.
 */
public class ServiceModel {
    private String id;
    private String name;

    /**
     * Constructor to instantiate the service model.
     *
     * @param id the id
     * @param name the name
     */
    public ServiceModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

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
     * Method to check equality with another object
     *
     * @param o object to compare
     * @return true if equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServiceModel that = (ServiceModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }

        return name != null ? name.equals(that.name) : that.name == null;
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
        return result;
    }
}
