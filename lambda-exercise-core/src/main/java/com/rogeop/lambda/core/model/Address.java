package com.rogeop.lambda.core.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Address is a model class that contains address information
 * 
 * @author Robert Pepersack
 * @version 1.0
 */
public class Address implements Serializable {

    private static final long serialVersionUID = -3761222739131836319L;

    private int addressId;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;
    private AddressType addressType;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, addressType, city, state, street1, street2, zipCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Address other = (Address) obj;
        return addressId == other.addressId && addressType == other.addressType && Objects.equals(city, other.city)
                && Objects.equals(state, other.state) && Objects.equals(street1, other.street1)
                && Objects.equals(street2, other.street2) && Objects.equals(zipCode, other.zipCode);
    }

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", addressType=" + addressType + "]";
    }

    public static class AddressBuilder {

        private final Address address;

        private AddressBuilder() {
            address = new Address();
        }

        public AddressBuilder addressId(int addressId) {
            address.setAddressId(addressId);
            return this;
        }

        public AddressBuilder street1(String street1) {
            address.setStreet1(street1);
            return this;
        }

        public AddressBuilder street2(String street2) {
            address.setStreet2(street2);
            return this;
        }

        public AddressBuilder city(String city) {
            address.setCity(city);
            return this;
        }

        public AddressBuilder state(String state) {
            address.setState(state);
            return this;
        }

        public AddressBuilder zipCode(String zipCode) {
            address.setZipCode(zipCode);
            return this;
        }

        public AddressBuilder addressType(AddressType addressType) {
            address.setAddressType(addressType);
            return this;
        }

        public Address address() {
            return address;
        }

    }

}