package com.example.grupp2_system.Customer;

import java.util.Random;

public class Customer {

    Random random = new Random();
    private String name;
    private String phoneNumber;
    private String personnummer;
    private String email;
    private String customerID;

    public Customer() {
        this.customerID = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public String getCustomerID() {
        return customerID;
    }

    private String generateCustomerId() {
        int number = 10000 + random.nextInt(90000);
        return "CustomerID-" + number;
    }

    public String toFileString() {
        return customerID + ";" +
                name + ";" +
                phoneNumber + ";" +
                personnummer + ";" +
                email;
    }
}
