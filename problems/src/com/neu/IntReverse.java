package com.neu;

/**
 * Created by raghu on 12/15/2016.
 */
public class IntReverse {

    public static void main(String[] args) {
        IntReverse ir = new IntReverse();
        System.out.println(ir.reverse(1534236469));
    }

    public int reverse(int z) {
        long x = z;
        long y = 0;
        System.out.println(x);
        long count = 0;
        long x1 = x;
        x = Math.abs(x);
        while (x >= 10) {
            long i = x % 10;

            x = (x - i) / 10;
              //System.out.println(x);
              //System.out.println(i);
            if (count == 0) {
                y = i;
            } else {
                y = (y * 10) + i;
            }
            count++;
            //System.out.println(y);
        }

        y = (y * 10) + x;
        if(y >= Integer.MAX_VALUE)
        {
            return 0;
        }


        if (x1 < 0)
            return -1 * (int)y;
        else
            return (int)y;
    }
}
