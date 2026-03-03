package com.example.grupp2_system.Booking;

import java.io.*;
import java.time.LocalDate;
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

                String[] parts = line.split(";");

                Booking booking = new Booking(
                        parts[0],
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        parts[4],
                        parts[5],
                        parts[6],
                        LocalDate.parse(parts[7]),
                        Double.parseDouble(parts[8]),
                        Boolean.parseBoolean(parts[9])
                );

                bookings.add(booking);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    //Method for finding a Booking with it's ID
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