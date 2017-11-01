package com.example.kumud.busapplication2;

/**
 * Created by Kumud on 10/11/17.
 */

public class Schedule {
    public String pickupLocation;
    public String tour;
    public String listshifts;

    public  Schedule(){}

    public Schedule(String pickupLocation, String tour,  String listshifts) {
        this.pickupLocation = pickupLocation;
        this.tour = tour;
        this.listshifts = listshifts;
    }


    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }


    public String getListshifts() {
        return listshifts;
    }

    public void setListshifts(String listshifts) {
        this.listshifts = listshifts;
    }
}
