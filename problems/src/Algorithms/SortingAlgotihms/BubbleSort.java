package Algorithms.SortingAlgotihms;

/**
 * Created by raghu on 12/20/2016.
 */
public class BubbleSort {
    public static void main(String[] args) {

        int a[] = {8,7,6,5,4};

        int b[] = new BubbleSort().bubbleSort(a);

        for(int i=0; i<b.length;i++)
        {
            System.out.println(b[i]);
        }
    }

    public int[] bubbleSort(int[] a)
    {
        for(int i=0; i<a.length-1;i++)
        {
            int swapCount = 0;
            for(int j = 0 ; j < (a.length-1-i); j++)
            {
                if(a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapCount++;
                }

            }

            if(swapCount == 0)
            {
                break;
            }
        }
        return a;
    }
}
