package com.neu.bBy;

/**
 * Created by raghu on 12/18/2016.
 */
public class SmallestChange {
    public static void main(String[] args) {
        int[] denom = {1, 5, 10, 25};
        int x =500;

        long startTime = System.currentTimeMillis();
        System.out.println(new SmallestChange().smallestChange(x, denom));
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time: " + (endTime-startTime));

    }

    public int smallestChange(int num, int[] denom)
    {
        if(num == 0) return 0;

        int min = num;
        for(int i : denom)
        {
            int change = num - i;
            if(change >= 0)
            {
                int c = smallestChange(change,denom);
                if(min > c+1) min = c+1;
            }

        }
        return min;
    }

}
