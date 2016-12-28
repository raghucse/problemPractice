package com.neu.bBy;

/**
 * Created by raghu on 12/26/2016.
 */
public class GrayNumber {
    public static void main(String[] args) {
        System.out.println(new GrayNumber().grayNumberWc(0b00010,0b11010));
    }

    public Boolean grayNumber(int a, int b)
    {
        int c = a^b;
        int count = 0;

        while (c > 0)
        {
            if( (c & 1) == 1)
            {
                count++;
            }
            c = c >>> 1;
        }

        return (count > 1 ? false : true);
    }

    public Boolean grayNumberWc(int a, int b)
    {
        int c = a^b;


        while (c > 0)
        {
            if( (c & 1) == 1 && (c >> 1) > 0)
            {
                return false;
            }
            c = c >>> 1;
        }

        return true;
    }
}
