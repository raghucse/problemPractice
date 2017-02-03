package com.neu.CCI.RecursionAndDynamicProgramming;

/**
 * Created by raghu on 1/6/2017.
 */
public class RecursiveMultiply {
    public static void main(String[] args) {
        int a = 6;
        int b = 6;

        int bigger = Math.max(a,b);
        int smaller =  Math.min(a,b);

     //   System.out.println(new RecursiveMultiply().recursiveMultiply(smaller, bigger));



    }

    public int  recursiveMultiply(int smaller, int bigger)
    {
        if(smaller == 0)
            return 0;

        if(smaller == 1)
            return bigger;

        int s = smaller >> 1; //dive by 2 just to find out sum
        System.out.println(s);
        int halfProd = recursiveMultiply(s, bigger);

        if(smaller %2 ==0)
        {
            return halfProd + halfProd;
        }
        else
        {
            return halfProd + halfProd + bigger;
        }
    }
}
