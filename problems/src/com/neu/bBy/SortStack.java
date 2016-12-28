package com.neu.bBy;

import java.util.Stack;

/**
 * Created by raghu on 12/24/2016.
 */
public class SortStack {

    Stack<Integer> sortedStatck = new Stack<>();

    public static void main(String[] args) {
        Stack<Integer> unSortedStatck = new Stack<>();
        unSortedStatck.push(4);
        unSortedStatck.push(1);
        unSortedStatck.push(5);
        unSortedStatck.push(2);
        unSortedStatck.push(3);
        System.out.println(unSortedStatck);

        SortStack ss = new SortStack();
        ss.sortStack(unSortedStatck);

        System.out.println(ss.sortedStatck);
    }

//Much simplementation than mine
    public void sortStack(Stack<Integer> s)
    {
        if(s == null && s.isEmpty() )
        {
            return;
        }
        sortedStatck.push(s.pop());

        while(!s.isEmpty())
        {
            int item = s.pop();
            while (!sortedStatck.isEmpty() && item > sortedStatck.peek())
            {
                s.push(sortedStatck.pop());
            }
            sortedStatck.push(item);
        }

    }



    public void sortStack2(Stack<Integer> s)
    {
        if(s == null && s.isEmpty() )
        {
            return;
        }
        sortedStatck.push(s.pop());
        while (!s.isEmpty())
        {
            int item = s.pop();


                if(item < sortedStatck.peek())
                {
                     sortedStatck.push(item);
                }
                else
                {
                    int count = 0;
                    while ( !sortedStatck.empty() && sortedStatck.peek() < item) //error
                    {
                        s.push(sortedStatck.pop());
                        count++;
                    }
                    sortedStatck.push(item);
                    while (count>0)
                    {
                        sortedStatck.push(s.pop());
                        count--;
                    }

                }

        }
    }
}
