package com.neu.CCI.BitManipulation;

import com.neu.Solution;

/**
 * Created by raghu on 1/4/2017.
 */
public class Conversion {
    public static void main(String[] args) {
        new Conversion().methodTwo(29,15);
    }


    public void methodOne(int a, int b)
    {

        int count = 0;
        for(int i = a^b; i!=0; i >>>=1)
        {


            if((i & 1) == 1)
                count++;


        }

        System.out.println(count);
    }


    //didnt understand the method
    public void methodTwo(int a, int b)
    {
        int count = 0 ;

        int k = a^b;
        System.out.println(k+" "+Integer.toBinaryString(k));
        System.out.println((k-1)+" "+Integer.toBinaryString(k-1));
        k = k & (k-1);
        System.out.println(k+" "+Integer.toBinaryString(k));
        System.out.println((k-1)+" "+Integer.toBinaryString(k-1));
        k = k & (k-1);
        System.out.println(k+" "+Integer.toBinaryString(k));
        System.out.println((k-1)+" "+Integer.toBinaryString(k-1));


        for(int i = a^b; i != 0; i = i & (i-1))
        {
            System.out.println(i);
            count++;
        }

        System.out.println(count);

    }
}
