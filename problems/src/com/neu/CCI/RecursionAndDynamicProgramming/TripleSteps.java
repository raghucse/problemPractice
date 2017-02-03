package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * Created by raghu on 1/6/2017.
 */
public class TripleSteps {
    static int count = 0;
    public static void main(String[] args) {
        TripleSteps ts = new TripleSteps();
        System.out.println(ts.countWays(29));
        ts.countWaysMyway(29);
        System.out.println(TripleSteps.count);
        int array[] = new int[29+1];
        Arrays.fill(array, -1);
        ;
        System.out.println(ts.countWays(29,array));

    }

    int countWays(int n) {
         if (n < 0) {
             return 0;
             } else if (n == 0) {
             return 1;
             } else {
            return countWays(n-1) + countWays(n-2)+ countWays(n-3);
        }
    }


    ///The amazing dynamic programming technique
    int countWays(int n, int possibleWays[]) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            if(possibleWays[n]==-1){
                possibleWays[n] = countWays(n-1) + countWays(n-2)+ countWays(n-3);

            }

             return possibleWays[n];
        }
    }

    public void countWaysMyway(int n)
    {
        if(n==0)
        {
            count++;
            return ;
        }

        if(n < 0)
        {
            return;
        }
        countWaysMyway(n-1);
        countWaysMyway(n-2);
        countWaysMyway(n-3);
    }

}
