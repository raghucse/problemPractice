package com.neu.bBy;

/**
 * Created by raghu on 12/23/2016.
 */
public class MergeArray {
    public static void main(String[] args) throws Exception{
        int a[] = new int[]{1,3,6,0,0,0};
        int b[] = new int[]{2,4,5};

           new MergeArray().mergeArray(a, b);

    }

    public void mergeArray(int a[], int b[]) throws Exception
    {


        int shortAray[] ;
        int longArray[];

        int i ;
        int j ;
        int k ;

        if(a.length < b.length)
        {
            shortAray = a;
            longArray = b;
        }
        else
        {
            shortAray = b;
            longArray = a;
        }

            // throw exception id not enough space
        k = longArray.length-1;
        j = shortAray.length-1;

        i = 0;
        while(a[i+1] != 0)
        {
            i++;
        }

        while (j >= 0 && i >=0)
        {
            if(shortAray[j] > longArray[i])
            {
                longArray[k] = shortAray[j];
                j--;
                k--;
            }
            else
            {
                longArray[k] = longArray[i];
                i--;
                k--;
            }
        }

        while (j>=0)
        {
            longArray[k] = shortAray[j];
            j--;
            k--;
        }



        for (int l  = 0; l < longArray.length; l++)
        {
            System.out.println(longArray[l]);
        }

    }
}
