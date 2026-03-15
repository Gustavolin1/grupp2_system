package com.example.grupp2_system.Customer;

public class Customer {
    private String name;
    private String phoneNumber;
    private String personnummer;
    private String email;

    public Customer() {
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
}
