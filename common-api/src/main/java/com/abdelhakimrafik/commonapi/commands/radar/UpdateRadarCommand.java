package com.abdelhakimrafik.commonapi.commands.radar;

import com.abdelhakimrafik.commonapi.commands.BaseCommand;

public class UpdateRadarCommand extends BaseCommand<String> {
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public UpdateRadarCommand(String id, int maxSpeed, double longitude, double latitude) {
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
