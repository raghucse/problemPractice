package com.neu.bBy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by raghu on 12/24/2016.
 */
public class StackFromQueue {


    Queue<Integer> primary = new LinkedList<>();
    Queue<Integer> secondary =  new LinkedList<>();

    public static void main(String[] args) {
        StackFromQueue s = new StackFromQueue();

        s.push(5);
        s.push(6);

    //    System.out.println(s.pop());
        s.push(7);

        s.push(8);
   //     System.out.println(s.primary);
    //    System.out.println(s.secondary);
        System.out.println(s.pop());

      //  System.out.println(s.primary);
      //  System.out.println(s.secondary);
        System.out.println(s.pop());
        s.push(20);
        System.out.println(s.pop());


    }

    public void push(int item)
    {
        primary.add(item);
    }

    public int pop()
    {


        while (primary.size() != 1)
        {
            secondary.add(primary.remove());
        }
        int lastItem = primary.remove();
        primary = secondary;
        secondary = new LinkedList<>();
        return lastItem;

    }


}
