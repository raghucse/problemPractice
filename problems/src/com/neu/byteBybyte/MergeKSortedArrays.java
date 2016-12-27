package com.neu.byteBybyte;

import java.util.PriorityQueue;

/**
 * Created by raghu on 12/27/2016.
 */

class QueueNode implements Comparable<QueueNode>{
    int array, index, value;

    public QueueNode(int array, int index, int value)
    {
        this.array = array;
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(QueueNode n) {
        if(value > n.value) return 1;
        if(value < n.value) return -1;
        return 0;
    }
}

public class MergeKSortedArrays{
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        a[0] = new int[]{1,3,5};
        a[1] = new int[]{2,4,6};
        a[2] = new int[]{7,8,9};

        int b[] = new MergeKSortedArrays().merge(a);

        for(int i = 0; i < b.length; i++)
        {

                System.out.println(b[i]);

        }

    }

    public int[] merge(int[][] arrays)
    {
        PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();

        int size =0;
        for(int i =0; i< arrays.length; i++)
        {
            size += arrays[i].length;
            if(arrays[i].length >0)
            {
                pq.add(new QueueNode(i,0,arrays[i][0]));
            }
        }

        int[] result = new int[size];

        for(int i=0; !pq.isEmpty(); i++)
        {
            QueueNode n = pq.remove();
            result[i]= n.value;
            int newIndex = n.index +1;
            if(newIndex < arrays[n.array].length){
                pq.add(new QueueNode(n.array, newIndex, arrays[n.array][newIndex]));
            }
        }

        return result;
    }

}


