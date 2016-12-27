package com.neu.byteBybyte;

/**
 * Created by raghu on 12/27/2016.
 */
public class ClockAngle {

    public static void main(String[] args) {
        ClockAngle ca = new ClockAngle();
        ca.clock(12,30);
    }

    public void clock(double hr, double min)
    {
        double DEGREES_PER_MINUTE = 360.00/60.00;
        double DEGREES_PER_HOUR =  360.00/12.00;

        double minutesAngle = min * DEGREES_PER_MINUTE;
        double hoursAngle = (hr * DEGREES_PER_HOUR) + ((min/60.00) * DEGREES_PER_HOUR);

        // example hr = 12 min =30
   /*     if(hoursAngle >= 360)
        {
            hoursAngle = hoursAngle-360;
        }*/


        System.out.println(minutesAngle);
        System.out.println(hoursAngle);

        double angle = Math.abs(minutesAngle- hoursAngle);

        System.out.println(angle);

        if(angle > 180)
        {
            System.out.println(360-angle);
        }
        else
            System.out.println(angle);



    }
}
