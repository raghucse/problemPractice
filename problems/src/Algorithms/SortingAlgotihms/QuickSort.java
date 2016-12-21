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

    public void quickSort (int[] array, int lowerIndex, int higherIndex)
    {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
}


