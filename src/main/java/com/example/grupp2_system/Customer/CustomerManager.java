package com.example.grupp2_system.Customer;

import com.example.grupp2_system.Booking.Booking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerManager {


    private static final String FILE_NAME = "customer.txt";

    public static void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(customer.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
