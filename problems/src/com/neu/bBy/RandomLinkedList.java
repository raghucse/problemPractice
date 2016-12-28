package com.neu.bBy;

/**
 * Created by raghu on 12/25/2016.
 */
class RandomNode{
    int data;
    RandomNode next;
    RandomNode Random;

    RandomNode(int data)
    {
        this.data = data;
    }
}

public class RandomLinkedList {
    public static void main(String[] args) {

    }

    public RandomNode clone(RandomNode n)
    {
        RandomNode cur = n ;

        while (cur != null)
        {
            RandomNode temp = new RandomNode(cur.data);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        cur = n;

        while (cur != null)
        {
            cur.next.Random = cur.Random.next;
            cur = cur.next.next;
        }

        RandomNode copy = cur.next;
        cur = n;
        while (cur != null) {
            RandomNode temp = cur.next;
            temp.next = temp.next.next;

            cur.next = cur.next.next;
            cur = cur.next;

        }

        return copy;

    }
}
