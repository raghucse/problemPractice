package com.neu.byteBybyte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghu on 12/22/2016.
 */
public class Permutation {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        List<int[]> permList = new ArrayList<int[]>();
        new Permutation().permutation(a,0,permList);

        for(int[] i : permList)
        {
            for(int j=0; j < i.length ; j++)
            {
                System.out.print(i[j]+" ");
            }
            System.out.println("");
        }

    }

    public void permutation(int[] a, int start, List<int[]> permList)
    {
        if(start >= a.length)
        {
            permList.add(a.clone());
        }else
        {
            for(int i = start ; i< a.length; i++)
            {
                swap(i, start, a);
                permutation(a, start+1, permList);
                swap(i, start, a);
            }
        }

    }

    public void swap(int i, int j, int a[])
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
