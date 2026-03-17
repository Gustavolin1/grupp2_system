package com.example.grupp2_system.Customer;

import com.example.grupp2_system.Booking.Booking;

import java.io.*;
import java.util.List;

public class CustomerManager {


    private static final String BASE_PATH =
            System.getProperty("user.home") + "/MarsTravels/";

    private static final String FILE_NAME =
            BASE_PATH + "customer.txt";

    public static void saveCustomer(Customer customer) {
        File dir = new File(BASE_PATH);

        if (!dir.exists()) {
            dir.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(customer.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metod för att söka fram kunden
    public static String getCustomerInfo(String customerId) {
        File file = new File(FILE_NAME);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            return null;
        }
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

    public static Customer findCustomerById(String customerId) {
        File file = new File(FILE_NAME);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                if (parts[0].equals(customerId)) {
                    Customer customer = new Customer();
                    customer.setCustomerID(parts[0]);
                    customer.setName(parts[1]);
                    customer.setPhoneNumber(parts[2]);
                    customer.setPersonnummer(parts[3]);
                    customer.setEmail(parts[4]);
                    return customer;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    }

