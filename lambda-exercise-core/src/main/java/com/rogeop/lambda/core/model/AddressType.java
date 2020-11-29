package com.rogeop.lambda.core.model;

/**
 * AddressType represents types of addresses
 *
 * @author Robert Pepersack
 * @version 1.0
 */
public enum AddressType {
    HOME(1, "Home"), WORK(2, "Work"), VACATION(3, "Vacation");

    private AddressType(Integer addressTypeId, String addressType) {
        this.addressTypeId = addressTypeId;
        this.addressType = addressType;
    }

    public static final AddressType values[] = values();

    private final Integer addressTypeId;
    private final String addressType;

    public Integer addressTypeId() {
        return addressTypeId;
    }

    public String addressType() {
        return addressType;
    }

}