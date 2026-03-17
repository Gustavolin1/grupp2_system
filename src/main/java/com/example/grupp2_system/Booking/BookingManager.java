package com.example.grupp2_system.Booking;

import java.io.*;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private static final String FILE_NAME = "bookings.txt";

    public static void saveBooking(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(booking.toFileString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Booking> loadBookings() {

        List<Booking> bookings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");

                // You now have 19 fields
                if (parts.length < 19) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    Booking booking = new Booking(
                            parts[0], // bookingId
                            parts[1], // customerId
                            parts[2], // cabinThere
                            parts[3], // foodThere
                            Month.valueOf(parts[4]), // monthThere
                            Year.of(Integer.parseInt(parts[5])), // yearThere
                            parts[6], // hotelChoice
                            parts[7], // cabinHome
                            parts[8], // foodHome
                            Month.valueOf(parts[9]), // monthHome
                            Year.of(Integer.parseInt(parts[10])), // yearHome
                            Double.parseDouble(parts[11]), // cardAmount
                            Boolean.parseBoolean(parts[12]), // insurance
                            Integer.parseInt(parts[13]), // movie
                            Integer.parseInt(parts[14]), // concert
                            Integer.parseInt(parts[15]), // theatre
                            Integer.parseInt(parts[16]), // home movie
                            Integer.parseInt(parts[17]), // home concert
                            Integer.parseInt(parts[18])  // home theatre
                    );

                    bookings.add(booking);

                } catch (Exception e) {
                    System.out.println("Error parsing line: " + line);
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ingen bokningsfil hittades (helt okej första gången).");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // Method for finding a Booking with its ID
    public static Booking findBookingById(String bookingId) {

        List<Booking> bookings = loadBookings();

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }

        return null; // Not found
    }
}