package com.neu.byteBybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by raghu on 12/22/2016.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int a[] = new int[]{-1, 0, 1, 2, -1, -4};

    }

    public void threeSum(int a[])
    {
        Arrays.sort(a);
        List<int[]> result =new ArrayList<int[]>();
        for(int i=0; i < a.length; i++)
        {
            if(i == 0 || a[i] > a[i-1])
            {
                int start = 0;
                int end = a.length-1;

                while(start < end )
                {
                    if(a[i] + a[start] + a[end] == 0)
                    {
                        result.add(new int[]{a[i], a[start], a[end]});
                    }

                    if(a[i] + a[start] + a[end] < 0)
                    {
                        int currentStart =start;
                        while (a[currentStart] == a[start] && start < end)
                        {
                            start++;
                        }
                    }
                    else
                    {
                        int currentEnd = end;
                        while (a[currentEnd] == a[end] && start < end)
                        {
                            end--;
                        }
                    }
                }

            }
        }
    }
}
