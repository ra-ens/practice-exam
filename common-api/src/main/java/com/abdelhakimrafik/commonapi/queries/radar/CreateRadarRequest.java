package com.abdelhakimrafik.commonapi.queries.radar;

public class CreateRadarRequest {
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public CreateRadarRequest() {}

    public CreateRadarRequest(int maxSpeed, double longitude, double latitude) {
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
