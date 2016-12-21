package Algorithms.SortingAlgotihms;

/**
 * Created by raghu on 12/19/2016.
 * https://www.youtube.com/watch?v=f8hXR_Hvybo
 */
public class SelectionSort {


    public static void main(String[] args) {
        int a[] = {8,7,6,5,4};

        int b[] = selectionSort(a);

        for(int i=0; i<b.length;i++)
        {
            System.out.println(b[i]);
        }
    }

    public static int[] selectionSort(int[] a)
    {

        for(int i = 0 ; i< a.length;i++)
        {
            int min = i;
            for(int j = i+1; j<a.length;j++)
            {
                if(a[j] < a[min])
                {
                    min = j;
                }

            }
            if(min !=i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        return a;

    }
}
