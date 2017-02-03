package com.neu.CCI.RecursionAndDynamicProgramming;

/**
 * Created by raghu on 1/6/2017.
 */
public class MagicIndex {
    public static void main(String[] args) {
        int array[] = new int[]{1,2,3,3,5,6};

        System.out.println(new MagicIndex().magicIndex(0, array.length-1,array));
    }

    public int magicIndex(int start, int end, int array[])
    {
        if(end < start)
            return -1;

        int mid = (end+start) /2;
        if(mid == array[mid])
            return mid;

        int leftIndex = Math.min(mid-1, array[mid]);
        int leftValue = magicIndex(start, leftIndex, array);
        if( leftValue >= 0)
        {
            return leftValue;
        }

        int rightIndex = Math.min(mid+1, array[mid]);
        int rightValue = magicIndex(rightIndex, end, array);
        return rightValue;

    }
}
