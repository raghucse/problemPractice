package com.neu.bBy;

/**
 * Created by raghu on 12/30/2016.
 */
public class BigIntModulus {
    public static void main(String[] args) {
        byte[] a = new byte[2];
        a[0] = 0x06;
        a[1] = 0x3F;
        new BigIntModulus().bigIntMod(a,4);
    }

    public void bigIntMod(byte a[], int b)
    {
        int m=0;

        for(int i=0; i < a.length; i++)
        {
            m <<=8;
            System.out.println("1: "+Integer.toHexString(m));
            m += (a[i] & 0xFF);
            System.out.println("2: "+Integer.toHexString(m));
            m %= b;
            System.out.println("3: "+Integer.toHexString(m));
        }

        System.out.println(m);
    }
}
