package com.busticketmanagement.BusRoute;


public class BusRoute {
    private String routeName;
    private String travelCompany;
    private double price;
    private int availableSeats;
    private String travelDate;

    public BusRoute(String routeName, String travelCompany, double price, int availableSeats, String travelDate) {
        this.routeName = routeName;
        this.travelCompany = travelCompany;
        this.price = price;
        this.availableSeats = availableSeats;
        this.travelDate = travelDate;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getTravelCompany() {
        return travelCompany;
    }

    public void setTravelCompany(String travelCompany) {
        this.travelCompany = travelCompany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }
}

