package com.neu.byteBybyte;

/**
 * Created by raghu on 12/18/2016.
 */
public class SmallestChangeDynamic {

    public static void main(String[] args) {
        int[] denom = {1, 5, 10, 25};
        int x =32;

        long startTime = System.currentTimeMillis();
        System.out.println(new SmallestChangeDynamic().smallestChange(500, denom));
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time: " + (endTime-startTime));

    }

    public int smallestChange(int num, int[] denom)
    {
        int[] cache = new int[num];
        for(int i =0 ; i < cache.length;i++)
        {
            cache[i] = -1;
        }

        return smallestChange(num, denom, cache);
    }

    public int smallestChange(int num, int[] denom, int[] cache)
    {
        if(num == 0) return 0;

        int min = num;
        for(int i : denom)
        {
            int change = num - i;

            if(change >= 0)
            {
                int c;
                if(cache[change] >=0)
                {
                    c =cache[change];
                }
                else {
                    c = smallestChange(change, denom, cache);
                    cache[change] = c;
                }
                if(min > c+1) min = c+1;
            }

        }
        return min;
    }
}
