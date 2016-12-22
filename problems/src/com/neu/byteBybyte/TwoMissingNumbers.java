package com.neu.byteBybyte;

/**
 * Created by raghu on 12/21/2016.
 */
public class TwoMissingNumbers {
    public static void main(String[] args) {
        int a[] = new int[]{1,4,5,6};

        new TwoMissingNumbers().twoMissingNumbers(a);
    }

    public void twoMissingNumbers(int[] a)
    {
        long size = a.length +2;
        long totalSum = size * (size + 1)/2;
        int arrsum = 0;
        for(int i: a) {
            arrsum += i;
        }

        //System.out.println(arrsum);
        //System.out.println(totalSum+ " "+ size);

        int pivot = (int)((totalSum-arrsum)/2);
        //System.out.println(pivot);
        // int totalLeftXor = pivot * (pivot+1)/2;
        int totalLeftXor = 0;
        int totalRightXor = 0;

        for(int i = 1 ; i <= pivot ; i++)
        {
            totalLeftXor ^= i;
        }


        for(int i = pivot+1 ; i <= size ; i++)
        {
            totalRightXor ^= i;
        }

        int aLeft = 0;
        int aRight =0;


        for(int i=0; i< a.length;i++)
        {
         if(a[i] <= pivot)
             aLeft ^= a[i];
         else
             aRight ^= a[i];

        }

        int[] b = new int[]{totalLeftXor^aLeft, totalRightXor^aRight};

        for (int i:b) {
            System.out.println(i);
        }


    }
}
