package com.neu.bBy;

/**
 * Created by raghu on 12/22/2016.
 */
public class RotateBits {
    public static void main(String[] args) {
        int x = 0x00FFABCC;
        int y = 0x010;

 //       System.out.println(Integer.parseInt("ABFFABCC",16));
        new RotateBits().rotateBits(y, 32);
    }

    public void rotateBits(long x , int N)
    {
        System.out.println(Long.toBinaryString(x >> N | x <<(32-N) ));

        /* my implementation Current Implementation*/
  /*      int rightShit = x >>> N ;
        int leftShit = x << (32 - N);
        System.out.println(Integer.toHexString(rightShit));
        System.out.println(Integer.toHexString(leftShit));
        int number =  rightShit | leftShit;
        System.out.println(Integer.toHexString(number));*/
    }
}
