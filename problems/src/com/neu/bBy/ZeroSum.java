package com.neu.bBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghu on 12/23/2016.
 */
public class ZeroSum {

    public static void main(String[] args) {
        int a[] = new int[]{1,2,-5,1,2,-1};
        int b[] = new int[]{1,5,2,1,1,1,-1};
        new ZeroSum().zeroSum(b);
    }

    /* My Implementation */
    public void zeroSum(int a[])
    {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(a[0],0);

        int sum = a[0];
        for(int i = 1 ; i < a.length; i++)
        {
            sum +=  a[i];
           // System.out.println(sum);
            if(m.containsKey(sum))
            {
             //   System.out.println("Inside: "+sum+ " "+ a[i]);
                int j = m.get(sum);
                for (int k = j+1 ; k <= i ; k++) {
                    System.out.print(a[k]+" ");
                }
                return;
            }
            else
            {
                m.put(sum,i);
            }


        }
    }
}
