package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 */
public class Test {
    public static void main(String[] args) {
    //    System.out.println(Integer.BYTES);

       // System.out.println(Integer.toBinaryString(-1));
        int a  = 0b00000000000000000000000000000000;

        System.out.println(Long.toBinaryString((long)Math.pow(2,31)));


        System.out.println(a);
        long b = Long.BYTES * 64;
        System.out.println(b);

        long f = (long)Math.pow(2,34);
        System.out.println(Long.toBinaryString(f));
        System.out.println(f);

        System.out.println();

        long c = 0b1101;
        long d = ~c;
        System.out.println(Long.toBinaryString(d));

        System.out.println(Integer.toBinaryString(  7));
    }




    public int flipBits(int n)
    {
        //
        if(~n == 0) return n;


        return 0;


    }
}
