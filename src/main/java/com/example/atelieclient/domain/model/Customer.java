package com.example.atelieclient.domain.model;

public class Customer extends Entity {
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;

    public Customer(String firstName, String lastName, String middleName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }
}
