package Algorithms.SortingAlgotihms;

/**
 * Created by raghu on 12/20/2016.
 * https://www.youtube.com/watch?v=-7pzsM6gxgY
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {7,8,9,6,3,5,4,1,9,4};

        new QuickSort().quickSort(a, 0, a.length-1);

        for(int i=0; i<a.length;i++) {
            System.out.println(a[i]);
        }

    }

    public void quickSort (int[] a, int low, int high)
    {
            int i = low;
            int j = high;
            int  mid= low + (high - low) / 2; // Important for the higher index
            int  pivot = a[mid];

            while (i <= j) {

                while (a[i] < pivot) {
                    i++;
                }
                while (a[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }

        }

        if(low < j)
            quickSort(a, low, j);

        if(i < high)
            quickSort(a, i, high);
    }
}


