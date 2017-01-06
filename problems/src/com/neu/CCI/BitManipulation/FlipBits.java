package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 */
public class FlipBits {
    public static void main(String[] args) {
        int s = 0b11101111001111;

        new FlipBits().flipBits(s);
    }

    public void flipBits(int a)
    {
        int previous = 0;
        int current = 0;
        int maxLength = 0;


        while (a != 0)
        {
            if((a & 1) == 1)
                current++;
            else {
                previous = (a & 2) == 2 ? current : 0;
                current = 0;
            }


            a >>>=1;
            maxLength =  Math.max(previous+current+1, maxLength);

        }

        System.out.println(maxLength);

    }
}
