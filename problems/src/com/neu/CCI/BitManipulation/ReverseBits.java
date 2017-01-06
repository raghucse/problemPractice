package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 */
public class ReverseBits {
    public static void main(String[] args) {
        long a = 0b010;

        long c = new ReverseBits().reverse(0b011);
        System.out.println("Result: " +Long.toBinaryString(c)+" "+c);
        System.out.println(Long.toBinaryString(1073741824));

   //     long d = 3221225472;
   //     System.out.println(Long.toBinaryString();

    }

    public long reverseCorrect(long a)
    {
        long  result = 0;
        for (int i = 0; i < 32; i++) {
            result += a & 1;
            a >>>= 1;
            if (i < 31)
                result <<= 1;
        }
        return result;
    }


    public long reverse(long a)
    {
        long b =(long) Math.pow(2,31);

        for(int i=0; i < 32; i++)
        {
            if((a & b) == 1)
            {
                a <<=1;
                a = 1 | a;
            }
            else
            {
                a <<=1;
            }

          //  System.out.println(Long.toBinaryString(a));

        }
        return a;
    }

}
