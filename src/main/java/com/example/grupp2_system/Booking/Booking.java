package com.example.grupp2_system.Booking;

import java.time.LocalDate;
import java.util.Random;

public class Booking {

    private static final Random random = new Random();

    private String bookingId;
//"There" is for choices on the way there
    private String cabinThere;
    private String foodThere;
    private LocalDate dateThere;

    private String hotelChoice;
//"Home" is for choices in the way home
    private String cabinHome;
    private String foodHome;
    private LocalDate dateHome;
//cardAmount is the amount of money loaded to the card
    private double cardAmount;
//travelInsurance bool where 1 means they want insurance and 0 meant they don't want it
    private boolean travelInsurance;
    private int theatreTickets;
    private int movieTickets;
    private int concertTickets;
    private int monthsOnMars;

    // Constructor for new booking

    public Booking() {
        this.bookingId = generateBookingid();
    }

    private String generateBookingid()
    {
        int number = 10000 + random.nextInt(90000);
        return  "BK-" + number;
    }
    // Constructor used when loading from file
    public Booking(String bookingId,
                   String cabinThere,
                   String foodThere,
                   LocalDate dateThere,
                   String hotelChoice,
                   String cabinHome,
                   String foodHome,
                   LocalDate dateHome,
                   double cardAmount,
                   boolean travelInsurance){

        this.bookingId = bookingId;
        this.cabinThere = cabinThere;
        this.foodThere = foodThere;
        this.dateThere = dateThere;
        this.hotelChoice = hotelChoice;
        this.cabinHome = cabinHome;
        this.foodHome = foodHome;
        this.dateHome = dateHome;
        this.cardAmount = cardAmount;
        this.travelInsurance = travelInsurance;
    }



    // Convert object to one line for text file
    public String toFileString() {
        return bookingId + ";" +
                cabinThere + ";" +
                foodThere + ";" +
                dateThere + ";" +
                hotelChoice + ";" +
                cabinHome + ";" +
                foodHome + ";" +
                dateHome + ";" +
                cardAmount + ";" +
                travelInsurance;
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public String getCabinThere() { return cabinThere; }
    public String getFoodThere() { return foodThere; }
    public LocalDate getDateThere() { return dateThere; }
    public String getHotelChoice() { return hotelChoice; }
    public String getCabinHome() { return cabinHome; }
    public String getFoodHome() { return foodHome; }
    public LocalDate getDateHome() { return dateHome; }
    public double getCardAmount() { return cardAmount; }
    public boolean hasTravelInsurance() { return travelInsurance; }
    public int getTheatreTickets() {return theatreTickets;}
    public int getMovieTickets() {return movieTickets;}
    public int getConcertTickets() {return concertTickets;}
    public int getMonthsOnMars() {return  monthsOnMars;}
    //setter

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setCabinThere(String cabinThere) {
        this.cabinThere = cabinThere;
    }

    public void setFoodThere(String foodThere) {
        this.foodThere = foodThere;
    }

    public void setDateThere(LocalDate dateThere) {
        this.dateThere = dateThere;
    }

    public void setHotelChoice(String hotelChoice) {
        this.hotelChoice = hotelChoice;
    }

    public void setCabinHome(String cabinHome) {
        this.cabinHome = cabinHome;
    }

    public void setFoodHome(String foodHome) {
        this.foodHome = foodHome;
    }

    public void setDateHome(LocalDate dateHome) {
        this.dateHome = dateHome;
    }

    public void setCardAmount(double cardAmount) {
        this.cardAmount = cardAmount;
    }

    public void setTravelInsurance(boolean travelInsurance) {
        this.travelInsurance = travelInsurance;
    }

    public void setTheatreTickets(int theatreTickets) {theatreTickets = theatreTickets;}

    public void setMovieTickets(int movieTickets) {movieTickets = movieTickets;}

    public void setConcertTickets(int concertTickets) {
        this.concertTickets = concertTickets;}

    public void setMonthsOnMars(int monthsOnMars) {
        this.monthsOnMars = monthsOnMars;
    }
}
