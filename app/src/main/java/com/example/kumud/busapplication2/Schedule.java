package com.example.kumud.busapplication2;

/**
 * Created by Kumud on 10/11/17.
 */

public class Schedule {
    public String pickupLocation;
    public String tourTo;
    public String totalShifts;
    public String listshifts;

    public  Schedule(){}

    public Schedule(String pickupLocation, String tourTo, String totalShifts, String listshifts) {
        this.pickupLocation = pickupLocation;
        this.tourTo = tourTo;
        this.totalShifts = totalShifts;
        this.listshifts = listshifts;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getTourTo() {
        return tourTo;
    }

    public void setTourTo(String tourTo) {
        this.tourTo = tourTo;
    }

    public String getTotalShifts() {
        return totalShifts;
    }

    public void setTotalShifts(String totalShifts) {
        this.totalShifts = totalShifts;
    }

    public String getListshifts() {
        return listshifts;
    }

    public void setListshifts(String listshifts) {
        this.listshifts = listshifts;
    }
}
