package Algorithms.SortingAlgotihms;

/**
 * Created by raghu on 12/20/2016.
 */
public class MergeSort {

    public static void main(String[] args) {
        int a[] = {8,7,1,6,3,5,4,1,9,4};

     new MergeSort().mergeSort(a, 0, a.length-1);

        for(int i=0; i<a.length;i++) {
            System.out.println(a[i]);
        }


    }



    public void mergeSort(int[]a ,int low,int high )
    {

        if(low < high )
        {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, high, mid);
        }


    }

    public void merge(int a[], int low, int high, int mid)
    {
        int[] temp = new int[high+1];

        //storing into temp as we dont want to modify the original array
        for(int i = 0; i < temp.length; i++)
        {
            temp[i] = a[i];
        }

        int i = low;
        int j = mid+1;
        int k = low;

        System.out.println(i+" "+j+" "+k+" "+mid);
        while(i <= mid && j <= high)
        {
            if(temp[i] <= temp[j])
            {
                a[k] = temp[i];
                i++;
            }
            else
            {
                a[k] = temp[j];
                j++;
            }
            k++;
        }
        System.out.println(i+" "+j+" "+k);

       while (i<= mid)
        {
            a[k] = temp[i];
            i++;
            k++;
        }
        System.out.println(i+" "+j+" "+k);
       while (j<= high)
        {
            a[k] = temp[j];
            j++;
            k++;
        }
    }

}
