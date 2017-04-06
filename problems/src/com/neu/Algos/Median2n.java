package com.neu.Algos;

import java.util.Arrays;

/**
 * Created by raghu on 2/5/2017.
 * 9.3-8
 Let XŒ1 : : n and Y Œ1 : : n be two arrays, each containing n numbers already in
 sorted order. Give an O.lg n/-time algorithm to find the median of all 2n elements
 in arrays X and Y
 */
public class Median2n {
    public static void main(String[] args) {
        int x[] = {1,2,3,7,8};
        int y[] = {4,5,6,9,10};

        System.out.println(new Median2n().median(x,y));
    }

    double median(int[] x, int[] y)
    {
        int xLength = x.length;
        int yLength = y.length;

        if(xLength == 1)
            return Math.min(x[0],y[0]);

        double median = 0;
        int m = medianIndex(xLength);
        int i = m+1;
        if(x[m] < y[m])
        {

            median = median(Arrays.copyOfRange(x, i,xLength), Arrays.copyOfRange(y, 0, m));
        }
        else {

            median  = median(Arrays.copyOfRange(x, 0,i), Arrays.copyOfRange(y, i, yLength));
        }

        return median;
    }

    int medianIndex(int n)
    {
        if(n%2 == 0)
            return n/2;
        else
            return (n/2)-1;
    }
}
