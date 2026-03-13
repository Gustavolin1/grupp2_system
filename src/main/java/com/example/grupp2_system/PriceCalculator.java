package com.example.grupp2_system;

import com.example.grupp2_system.Booking.Booking;

public class PriceCalculator {

    public static int calculateTotalPrice(Booking booking) {
        if (booking == null) return 0;

        int total = 0;

        total += calculateCabinPrice(booking.getCabinThere());
        total += calculateCabinPrice(booking.getCabinHome());

        total += calculateFoodPrice(booking.getFoodThere());
        total += calculateFoodPrice(booking.getFoodHome());

        total += calculateEventPrice(booking);
        total += calculateInsurancePrice(booking);

        return total;
    }

    private static int calculateCabinPrice(String cabin) {
        if (cabin == null) return 0;

        switch (cabin) {
            case "Svit": return 1200000;
            case "Spaceside": return 700000;
            case "Inside": return 300000;
            case "Economy": return 180000;
            case "Sömnkapsel": return 2500000;
            default: return 0;
        }
    }

    private static int calculateFoodPrice(String food) {
        if (food == null) return 0;

        switch (food) {
            case "Budget 1": return 27000;
            case "Budget 2": return 40000;
            case "Budget 3": return 54000;
            case "Mellan 1": return 76000;
            case "Mellan 2": return 90000;
            case "Mellan 3": return 100000;
            case "Lyx 1": return 120000;
            case "Lyx 2": return 150000;
            case "Lyx 3": return 200000;
            default: return 0;
        }
    }

    private static int calculateEventPrice(Booking booking) {
        if (booking.getEvents() == null) return 0;
        return booking.getEvents().size() * 300;
    }

    private static int calculateInsurancePrice(Booking booking) {
        return booking.hasTravelInsurance() ? 50000 : 0;
    }
}