package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/4/2017.
 */
public class SwapOddEvenBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new SwapOddEvenBits().swapOddEvenBits(0b01010)));
    }

    public int swapOddEvenBits(int x)
    {
        return( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
    }

}
