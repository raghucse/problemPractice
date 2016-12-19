package com.neu;

/**
 * Created by raghu on 12/14/2016.
 */
public class MedianOfSorted {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Boolean isOdd = false;
        int lenCombined = nums1.length + nums2.length;
        int  mid = (int)Math.ceil((double) lenCombined/2.0);
        System.out.println(lenCombined);
        System.out.println();
        if(lenCombined % 2 != 0)
        {
            isOdd = true;
            mid = mid-1;

        }


        int i = 0;
        int j = 0;
        int k = 0;
        int[] com = new int[lenCombined];
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                com[k] = nums1[i];

                if(isOdd && k == mid)
                {
                    System.out.println(k+" "+com[k]+" "+mid);
                    return (double) com[k];
                }
                else if(k == mid)
                {

                    return ((double)com[k] + (double) com[k-1])/2.0;
                }
                k++;
                i++;
            }
            else
            {
                com[k] = nums2[j];

                if(isOdd && k == mid)
                {
                    return (double) com[k];
                }
                else if(k == mid)
                {
                    return ((double)com[k] + (double) com[k-1])/2.0;
                }
                k++;
                j++;

            }



        }

        if(i < nums1.length)
        {
            while (i<nums1.length)
            {
                com[k] = nums1[i];


                if(isOdd && k == mid)
                {
                    return (double) com[k];
                }
                else if(k == mid)
                {
                    return ((double)com[k] + (double) com[k-1])/2.0;
                }
                k++;
                i++;
            }
        }
        else if(j < nums2.length)
        {
            while (j<nums2.length)
            {
                com[k] = nums2[j];
                if(isOdd && k == mid)
                {
                    return (double) com[k];
                }
                else if(k == mid)
                {
                    return ((double)com[k] + (double) com[k-1])/2.0;
                }
                k++;
                j++;
            }
        }

        return 0.0;
    }
}
