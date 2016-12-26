package com.neu.byteBybyte;

/**
 * Created by raghu on 12/26/2016.
 */
public class SwapNotemp {
    public static void main(String[] args) {
        new SwapNotemp().swapNoTemp(-5,4);
    }

    public void swapNoTemp(int a, int b)
    {
        System.out.println(a+" "+b);
        a = a+b;
        b = a-b;
        a = a-b;


        System.out.println(a+" "+b);
    }
}
