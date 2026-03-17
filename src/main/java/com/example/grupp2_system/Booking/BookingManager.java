package com.example.grupp2_system.Booking;

import java.io.*;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private static final String BASE_PATH =
            System.getProperty("user.home") + "/Documents/MarsTravels/";

    private static final String FILE_NAME =
            BASE_PATH + "bookings.txt";

    public static void saveBooking(Booking booking) {
        File dir = new File(BASE_PATH);

        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(booking.toFileString());
            writer.newLine();
            System.out.println("Booking saved: " + booking.getBookingId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Booking> loadBookings() {
        List<Booking> bookings = new ArrayList<>();
        File dir = new File(BASE_PATH);

        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bookings;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length < 19) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    // Parse months and years safely
                    Month monthThere = (parts[4] == null || parts[4].isBlank()) ? null : Month.valueOf(parts[4].trim().toUpperCase());
                    Year yearThere = (parts[5] == null || parts[5].isBlank()) ? null : Year.of(Integer.parseInt(parts[5].trim()));
                    Month monthHome = (parts[9] == null || parts[9].isBlank()) ? null : Month.valueOf(parts[9].trim().toUpperCase());
                    Year yearHome = (parts[10] == null || parts[10].isBlank()) ? null : Year.of(Integer.parseInt(parts[10].trim()));

                    Booking booking = new Booking(
                            parts[0], // bookingId
                            parts[1], // customerId
                            parts[2], // cabinThere
                            parts[3], // foodThere
                            monthThere,
                            yearThere,
                            parts[6], // hotelChoice
                            parts[7], // cabinHome
                            parts[8], // foodHome
                            monthHome,
                            yearHome,
                            Double.parseDouble(parts[11]), // cardAmount
                            Boolean.parseBoolean(parts[12]), // travelInsurance
                            Integer.parseInt(parts[13]), // movieTicket
                            Integer.parseInt(parts[14]), // concertTicket
                            Integer.parseInt(parts[15]), // theatreTicket
                            Integer.parseInt(parts[16]), // homeMovieTickets
                            Integer.parseInt(parts[17]), // homeConcertTickets
                            Integer.parseInt(parts[18])  // homeTheatreTickets
                    );

                    bookings.add(booking);

                } catch (Exception e) {
                    System.out.println("Failed to parse line: " + line);
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    public static Booking findBookingById(String bookingId) {
        for (Booking booking : loadBookings()) {
            if (booking.getBookingId().equals(bookingId)) return booking;
        }
        return null;
    }
}