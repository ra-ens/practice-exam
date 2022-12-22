package com.abdelhakimrafik.commonapi.queries.radar;

import com.abdelhakimrafik.commonapi.queries.BaseRequest;

public class UpdateRadarRequest extends BaseRequest<String> {
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public UpdateRadarRequest(String id, int maxSpeed, double longitude, double latitude) {
        super(id);
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
