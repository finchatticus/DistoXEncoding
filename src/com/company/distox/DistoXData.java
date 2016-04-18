package com.company.distox;

/**
 * Created by cooper on 17.04.16.
 */
public class DistoXData {
    private double distance;
    private double azimuth;
    private double inclination;
    private double rollAngle;

    public DistoXData() {
    }

    public DistoXData(double distance, double azimuth, double inclination, double rollAngle) {
        this.distance = distance;
        this.azimuth = azimuth;
        this.inclination = inclination;
        this.rollAngle = rollAngle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public double getInclination() {
        return inclination;
    }

    public void setInclination(double inclination) {
        this.inclination = inclination;
    }

    public double getRollAngle() {
        return rollAngle;
    }

    public void setRollAngle(double rollAngle) {
        this.rollAngle = rollAngle;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("distance: ").append(distance).append("; azimuth: ").append(azimuth).append("; inclination: ").append(inclination).append("; rollAngle ").append(rollAngle).toString();
    }
}
