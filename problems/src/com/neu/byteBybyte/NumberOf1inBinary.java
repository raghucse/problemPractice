package com.neu.byteBybyte;

/**
 * Created by raghu on 12/18/2016.
 * find number of 1's in a binary
 */
public class NumberOf1inBinary {
    public static void main(String[] args) {

        System.out.println(new NumberOf1inBinary().numberOf1Binary(5));
    }

    public int numberOf1Binary(int num)
    {
        int count = 0;
        while (num > 0)
        {
            count += num & 1;
           // System.out.println(num ^ 1);
            // count += num%2;

            num >>= 1;
        }
        return count;
    }
}
