package com.example.grupp2_system.Booking;

import java.time.Month;
import java.time.Year;
import java.util.Random;

public class Booking {

    private static final Random random = new Random();

    private String bookingId;
    private String customerId;

    //"There" is for choices on the way there
    private String cabinThere;
    private String foodThere;
    private Month monthThere;
    private Year yearThere;

    private String hotelChoice;

    //"Home" is for choices on the way home
    private String cabinHome;
    private String foodHome;
    private Month monthHome;
    private Year yearHome;

    private int monthsOnMars;

    //cardAmount is the amount of money loaded to the card
    private double cardAmount;

    //travelInsurance bool where true means they want insurance
    private boolean travelInsurance;

    //Event tickets there
    private int movieTicket;
    private int concertTicket;
    private int theatreTicket;

    //Event tickets home

    private int homeMovieTickets;
    private int homeConcertTickets;
    private int homeTheatreTickets;

    // Constructor for new booking
    public Booking() {
        this.bookingId = generateBookingId();
    }

    private String generateBookingId() {
        int number = 10000 + random.nextInt(90000);
        return "BK-" + number;
    }

    // Constructor used when loading from file
    public Booking(String bookingId,
                   String customerId,
                   String cabinThere,
                   String foodThere,
                   Month monthThere,
                   Year yearThere,
                   String hotelChoice,
                   String cabinHome,
                   String foodHome,
                   Month monthHome,
                   Year yearHome,
                   double cardAmount,
                   boolean travelInsurance,
                   int movieTicket,
                   int concertTicket,
                   int theatreTicket,
                   int homeMovieTickets,
                   int homeConcertTickets,
                   int homeTheatreTickets) {

        this.bookingId = bookingId;
        this.customerId = customerId;
        this.cabinThere = cabinThere;
        this.foodThere = foodThere;
        this.monthThere = monthThere;
        this.yearThere = yearThere;
        this.hotelChoice = hotelChoice;
        this.cabinHome = cabinHome;
        this.foodHome = foodHome;
        this.monthHome = monthHome;
        this.yearHome = yearHome;
        this.cardAmount = cardAmount;
        this.travelInsurance = travelInsurance;
        this.movieTicket = movieTicket;
        this.concertTicket = concertTicket;
        this.theatreTicket = theatreTicket;
        this.homeMovieTickets = homeMovieTickets;
        this.homeConcertTickets = homeConcertTickets;
        this.homeTheatreTickets = homeTheatreTickets;
    }

    // Convert object to one line for text file
    public String toFileString() {
        return bookingId + ";" +
                safe(customerId) + ";" +
                safe(cabinThere) + ";" +
                safe(foodThere) + ";" +
                safe(monthThere) + ";" +
                safe(yearThere) + ";" +
                safe(hotelChoice) + ";" +
                safe(cabinHome) + ";" +
                safe(foodHome) + ";" +
                safe(monthHome) + ";" +
                safe(yearHome) + ";" +
                String.format("%.0f", cardAmount) + ";" +
                travelInsurance + ";" +
                movieTicket + ";" +
                concertTicket + ";" +
                theatreTicket + ";" +
                homeMovieTickets + ";" +
                homeConcertTickets + ";" +
                homeTheatreTickets;
    }

    private String safe(Object value) {
        return value == null ? "" : value.toString();
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public String getCustomerId() { return customerId; }

    public String getCabinThere() { return cabinThere; }
    public String getFoodThere() { return foodThere; }
    public Month getMonthThere() { return monthThere; }
    public Year getYearThere() { return yearThere; }

    public String getHotelChoice() { return hotelChoice; }

    public String getCabinHome() { return cabinHome; }
    public String getFoodHome() { return foodHome; }
    public Month getMonthHome() { return monthHome; }
    public Year getYearHome() { return yearHome; }

    public int getMonthsOnMars() { return monthsOnMars; }

    public double getCardAmount() { return cardAmount; }
    public boolean hasTravelInsurance() { return travelInsurance; }

    public int getMovieTicket() { return movieTicket; }
    public int getConcertTicket() { return concertTicket; }
    public int getTheatreTicket() { return theatreTicket; }

    public boolean isTravelInsurance() {
        return travelInsurance;
    }

    public int getHomeMovieTickets() {
        return homeMovieTickets;
    }

    public int getHomeConcertTickets() {
        return homeConcertTickets;
    }

    public int getHomeTheatreTickets() {
        return homeTheatreTickets;
    }

    // Setters
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public void setCabinThere(String cabinThere) { this.cabinThere = cabinThere; }
    public void setFoodThere(String foodThere) { this.foodThere = foodThere; }
    public void setMonthThere(Month monthThere) { this.monthThere = monthThere; }
    public void setYearThere(Year yearThere) { this.yearThere = yearThere; }

    public void setHotelChoice(String hotelChoice) { this.hotelChoice = hotelChoice; }

    public void setCabinHome(String cabinHome) { this.cabinHome = cabinHome; }
    public void setFoodHome(String foodHome) { this.foodHome = foodHome; }
    public void setMonthHome(Month monthHome) { this.monthHome = monthHome; }
    public void setYearHome(Year yearHome) { this.yearHome = yearHome; }

    public void setMonthsOnMars(int monthsOnMars) { this.monthsOnMars = monthsOnMars; }

    public void setCardAmount(double cardAmount) { this.cardAmount = cardAmount; }

    public void setTravelInsurance(boolean travelInsurance) { this.travelInsurance = travelInsurance; }

    public void setMovieTicket(int movieTicket) { this.movieTicket = movieTicket; }
    public void setConcertTicket(int concertTicket) { this.concertTicket = concertTicket; }
    public void setTheatreTicket(int theatreTicket) { this.theatreTicket = theatreTicket; }

    public void setHomeMovieTickets(int homeMovieTickets) {
        this.homeMovieTickets = homeMovieTickets;
    }

    public void setHomeConcertTickets(int homeConcertTickets) {
        this.homeConcertTickets = homeConcertTickets;
    }

    public void setHomeTheatreTickets(int homeTheatreTickets) {
        this.homeTheatreTickets = homeTheatreTickets;
    }
}