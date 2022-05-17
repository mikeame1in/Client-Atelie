package com.example.atelieclient.model;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String phone;

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
