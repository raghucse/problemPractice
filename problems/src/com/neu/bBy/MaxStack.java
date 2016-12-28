package com.neu.bBy;

/**
 * Created by raghu on 12/18/2016.
 * clarify what kind of data are they storing
 */
class Stack<T>{
    T data;
    Stack<T> next;
    Stack<T> previousMax;
    Stack(T a)
    {
        data = a;
    }
}


public class MaxStack<T> {
    Stack<T> top = null;
    Stack<T> max;

    public static void main(String[] args) {
         MaxStack<Integer> m = new MaxStack<Integer>();
         m.push(new Stack<Integer>(4));
         m.push(new Stack<Integer>(5));
         m.push(new Stack<Integer>(3));
         m.push(new Stack<Integer>(6));
         m.pop();

        System.out.println(m.getMax());

    }

    public void push(Stack<T> p)
    {
        p.next = top;
        top = p;
        if((max == null ||  (Integer)p.data > (Integer)max.data))
        {
             p.previousMax = max;
             max = p;
        }
    }

    public void pop()
    {
        if((Integer)top.data == (Integer) max.data)
        {
            max = top.previousMax;
        }
        top = top.next;


      /*  Stack<T> temp = top;
        max = 0;



        while (temp != null)
        {
            if((Integer)temp.data > max)
            {
                max = (Integer) temp.data;
            }
            temp = temp.next;
        } */
    }

    public int getMax()
    {
        return (Integer) max.data;
    }

}
