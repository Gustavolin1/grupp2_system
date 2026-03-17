package com.example.grupp2_system.Customer;

import com.example.grupp2_system.Booking.Booking;

import java.io.*;

public class CustomerManager {


    private static final String FILE_NAME =
            System.getProperty("user.home") + "/customer.txt";

    public static void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(customer.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metod för att söka fram kunden
    public static String getCustomerInfo(String customerId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // Split line by semicolon
                String[] parts = line.split(";");

                if (parts.length < 5) continue; // Adjust if you add/remove fields

                String id = parts[0];
                if (id.equals(customerId)) {
                    String name = parts[1];
                    String phone = parts[2];
                    String personalNumber = parts[3];
                    String email = parts[4];

                    return String.format(
                            "Namn: %s\nTelefonnr: %s\nPersonnummer: %s\nEmail: %s",
                            name, phone, personalNumber, email
                    );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // customer not found
    }
}
