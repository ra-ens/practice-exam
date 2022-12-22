package com.abdelhakimrafik.commonapi.events.radar;


import com.abdelhakimrafik.commonapi.events.BaseEvent;

public class RadarCreatedEvent extends BaseEvent<String> {
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public RadarCreatedEvent() {}

    public RadarCreatedEvent(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
        this.maxSpeed = maxSpeed;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
