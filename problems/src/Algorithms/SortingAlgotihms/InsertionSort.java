package Algorithms.SortingAlgotihms;

/**
 * Created by raghu on 12/19/2016.
 * //https://www.youtube.com/watch?v=DFG-XuyPYUQ
 */
public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {8,7,6,5,4};

        int b[] = new InsertionSort().insertionSort(a);

        for(int i=0; i<b.length;i++)
        {
            System.out.println(b[i]);
        }
    }

    public int[] insertionSort(int[] a)
    {

        for(int i=1; i<a.length;i++)
        {
            int element = a[i];
            int j =i;

            while(j >0 &&  a[j-1] > element )
            {
                a[j] = a[j-1];
                j= j-1;
            }
            a[j] = element;

            //My method
           /* for(int j=i; j>0; j--)
            {
                if(a[j] < a[j-1])
                {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                else {
                    break;}

            }*/


        }
        return a;
    }
}
