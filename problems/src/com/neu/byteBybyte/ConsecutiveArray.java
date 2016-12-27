package com.neu.byteBybyte;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by raghu on 12/27/2016.
 */
public class ConsecutiveArray {

    public static void main(String[] args) {

        int[] a = new int[]{3,4,5,7,9};

        new ConsecutiveArray().consecutiveArray(a);
    }

    public void consecutiveArray(int[] a)
    {
        Set<Integer> hashSet = new HashSet<Integer>();

        for(int i: a)
        {
            hashSet.add(i);
        }

        int maxLength =0;

        for(int i: hashSet)
        {
            if(hashSet.contains(i-1)) continue;
            int length = 0;
            while (hashSet.contains(i++))
                length++;

            maxLength = Math.max(maxLength, length);
        }

        System.out.println(maxLength);
    }
}
