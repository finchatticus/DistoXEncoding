package com.company.distox;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by cooper on 17.04.16.
 */
public class DistoXEncoding {
    private byte[] data;
    private double distance;
    private double azimuth;
    private double inclination;
    private double rollAngle;
    private DistoXData encodingData;

    public DistoXEncoding(byte[] data) {
        this.data = data;
        encoding();
        encodingData = new DistoXData(distance, azimuth, inclination, rollAngle);
    }

    private void encoding() {
        int encDistance = ((data[1] & 0xFF) + ((data[2] & 0xFF) << 8)) + ((data[0] & 0x40) << 10);
        int encAzimuth = ((data[3] & 0xFF) + ((data[4] & 0xFF) << 8));
        short encInclination = (short) ((data[5] & 0xFF) + ((data[6] & 0xFF) << 8));
        byte encRollAngle = data[7];

        distance = round(encDistance * 0.001, 3);
        azimuth = round((encAzimuth * 180) / Math.pow(2,15), 1);
        inclination = round ((encInclination * 180) / Math.pow(2,15), 1);
        rollAngle = round((encRollAngle * 180) / Math.pow(2,7), 1);
    }

    private double round(double number, int precision) {
        return new BigDecimal(number).setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }

    private String byteToBinaryStr(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public DistoXData getEncodingData() {
        return encodingData;
    }
}
