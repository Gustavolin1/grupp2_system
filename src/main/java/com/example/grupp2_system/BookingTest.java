package com.example.grupp2_system;
import java.time.LocalDate;
import java.util.List;

//This class if just to test the functionality of the Booking object and the BookingManager
public class BookingTest {

    public static void main(String[] args) {

        // 1️⃣ Create a test booking
        Booking testBooking = new Booking(
                "Economy",
                "Budget2",
                LocalDate.of(2026, 6, 1),
                "HotelDeimos",
                "Spaceside",
                "Lyx1",
                LocalDate.of(2026, 6, 14),
                50000.0,
                true
        );

        // 2️⃣ Save booking to file
        BookingManager.saveBooking(testBooking);
        System.out.println("Booking saved successfully!");

        // 3️⃣ Load all bookings from file
        List<Booking> bookings = BookingManager.loadBookings();

        System.out.println("\nAll bookings in file:");

        // 4️⃣ Print them to verify retrieval works
        for (Booking b : bookings) {
            System.out.println("----------------------------");
            System.out.println("Booking ID: " + b.getBookingId());
            System.out.println("Cabin There: " + b.getCabinThere());
            System.out.println("Food There: " + b.getFoodThere());
            System.out.println("Date There: " + b.getDateThere());
            System.out.println("Hotel: " + b.getHotelChoice());
            System.out.println("Cabin Home: " + b.getCabinHome());
            System.out.println("Food Home: " + b.getFoodHome());
            System.out.println("Date Home: " + b.getDateHome());
            System.out.println("Card Amount: " + b.getCardAmount());
            System.out.println("Insurance: " + b.hasTravelInsurance());
        }

        // Create and save booking
        Booking testBooking2 = new Booking(
                "Economy",
                "Vegetarian",
                LocalDate.of(2026, 6, 1),
                "Hilton Hotel",
                "Business",
                "Standard",
                LocalDate.of(2026, 6, 14),
                5000.0,
                true
        );

        BookingManager.saveBooking(testBooking2);

        System.out.println("Saved booking with ID: " + testBooking2.getBookingId());

        // 🔍 Find booking by ID
        Booking foundBooking = BookingManager.findBookingById(testBooking2.getBookingId());

        if (foundBooking != null) {
            System.out.println("\nBooking Found!");
            System.out.println("Hotel: " + foundBooking.getHotelChoice());
            System.out.println("Insurance: " + foundBooking.hasTravelInsurance());
        } else {
            System.out.println("Booking not found.");
        }
    }
}