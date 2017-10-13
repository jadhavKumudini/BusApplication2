package com.example.kumud.busapplication2;

/**
 * Created by Kumud on 10/11/17.
 */

public class Location {

    public String locationName;
    public String locationLatitude;
    public String locationLongitude;

    public Location(){}

    public Location(String locationName, String locationLatitude, String locationLongitude) {
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }
}
