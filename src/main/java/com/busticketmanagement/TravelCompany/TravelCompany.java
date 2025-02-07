package com.busticketmanagement.TravelCompany;


public class TravelCompany {
    private String name;         // VRL Travels, SRS, KSRTC, etc.
    private String contactNumber;
    private String address;
    private double rating;      // Rating out of 5

    // Constructor
    public TravelCompany(String name, String contactNumber, String address, double rating) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.rating = rating;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

