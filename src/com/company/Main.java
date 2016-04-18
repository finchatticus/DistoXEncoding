package com.company;

import com.company.distox.DistoXData;
import com.company.distox.DistoXEncoding;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
	/*
	* dist 4.772 m
	* azim 338.9
	* incl 20.7
	*
	* bits
	* 0: 10000001 -127
	* 1: 10100100 -92  low byte of distance
	* 2: 00010010 18   high byte of distance
	* 3: 00000111 7    low byte of declination
	* 4: 11110001 -15  high byte of declination
	* 5: 10110111 -73  low byte of inclination
	* 6: 00001110 14   high byte of inclination
	* 7: 11101000 -24  high byte of roll angle
	 */
        //byte test1[] = {-127, -92, 18, 7, -15, -73, 14, -24};

        /*
	* dist 0.211 m
	* azim 69.0
	* incl -1.8
	*
	* bits
	* 0: 00000001 1
	* 1: 11010011 -45  low byte of distance
	* 2: 00000000 0    high byte of distance
	* 3: 00001111 15    low byte of declination
	* 4: 00110001 49  high byte of declination
	* 5: 10110001 -79  low byte of inclination
	* 6: 11111110 -2   high byte of inclination
	* 7: 00000011 3  high byte of roll angle
	 */
        byte test1[] = {1, -45, 0, 15, 49, -79, -2, 3};
        /*byte test1[] = {-127, 43, 1, -119, -66, 5, 0, -64};

        int dist = ((test1[1] & 0xFF) + ((test1[2] & 0xFF) << 8)) + ((test1[0] & 0x40) << 10);
        int azimuth = ((test1[3] & 0xFF) + ((test1[4] & 0xFF) << 8));
        short incl = (short) ((test1[5] & 0xFF) + ((test1[6] & 0xFF) << 8));
        byte roll = test1[7];

        double realDist = round(dist * 0.001, 3);
        double realAzimuth = round((azimuth * 180) / Math.pow(2,15), 1);
        double realIncl = round ((incl * 180) / Math.pow(2,15), 1);
        double realRoll = round((roll * 180) / Math.pow(2, 7), 1);
        System.out.println("dist " + realDist );
        System.out.println("azim " + realAzimuth );
        System.out.println("incl " + realIncl);
        System.out.println("roll " + realRoll);*/


        //int b = test1[2] << 8;
        //System.out.println(Integer.toBinaryString(b));

        DistoXEncoding distoXEncoding = new DistoXEncoding(test1);
        System.out.println(distoXEncoding.getEncodingData().toString());

    }

    private static String byteToBinaryStr(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public static double round(double number, int precision) {
        return new BigDecimal(number).setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }
}
