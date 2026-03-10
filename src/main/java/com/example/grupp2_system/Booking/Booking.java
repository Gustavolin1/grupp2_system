package com.example.grupp2_system.Booking;


import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Booking {

    private static final Random random = new Random();

    private String bookingId;
//"There" is for choices on the way there
    private String cabinThere;
    private String foodThere;
    private Month dateThere;
    private Year yearThere;

    private String hotelChoice;
//"Home" is for choices in the way home
    private String cabinHome;
    private String foodHome;
//cardAmount is the amount of money loaded to the card
    private double cardAmount;
//travelInsurance bool where 1 means they want insurance and 0 meant they don't want it
    private boolean travelInsurance;
    private List<String> events = new ArrayList<>();

    // Constructor for new booking

    public Booking(String part, String s, Month month, Year year, String part1, String s1, List<String> events, double v, boolean b) {
        this.bookingId = generateBookingid();
    }

    private String generateBookingid()
    {
        int number = 10000 + random.nextInt(90000);
        return  "BK-" + number;
    }
    // Constructor used when loading from file
    public Booking(String cabinThere,
                   String foodThere,
                   Month dateThere,
                   Year yearThere,
                   String hotelChoice,
                   String cabinHome,
                   String foodHome,
                   List<String> events,
                   double cardAmount,
                   boolean travelInsurance) {

        this.bookingId = generateBookingid(); // generate new ID
        this.cabinThere = cabinThere;
        this.foodThere = foodThere;
        this.dateThere = dateThere;
        this.yearThere = yearThere;
        this.hotelChoice = hotelChoice;
        this.cabinHome = cabinHome;
        this.foodHome = foodHome;
        this.events = events;
        this.cardAmount = cardAmount;
        this.travelInsurance = travelInsurance;
    }



    // Convert object to one line for text file
    public String toFileString() {
        String eventsString = String.join(",", events);
        return bookingId + ";" +
                cabinThere + ";" +
                foodThere + ";" +
                yearThere + ";" +
                dateThere + ";" +
                hotelChoice + ";" +
                cabinHome + ";" +
                foodHome + ";" +
                cardAmount + ";" +
                eventsString +";" +
                travelInsurance;
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public String getCabinThere() { return cabinThere; }
    public String getFoodThere() { return foodThere; }
    public Year getYearThere() { return yearThere; }
    public Month getDateThere() { return dateThere; }
    public String getHotelChoice() { return hotelChoice; }
    public String getCabinHome() { return cabinHome; }
    public String getFoodHome() { return foodHome; }
    public double getCardAmount() { return cardAmount; }
    public boolean hasTravelInsurance() { return travelInsurance; }
    public List<String> getEvents() {return events;}
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

    public void setYearThere(Year yearThere) {
        this.yearThere = yearThere;
    }

    public void setDateThere(Month dateThere) {
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

    public void setCardAmount(double cardAmount) {
        this.cardAmount = cardAmount;
    }

    public void setTravelInsurance(boolean travelInsurance) {
        this.travelInsurance = travelInsurance;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public void addEvent(String event){
        events.add(event);
    }
}