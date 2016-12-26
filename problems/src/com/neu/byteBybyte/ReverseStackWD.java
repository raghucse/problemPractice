package com.neu.byteBybyte;
import java.util.Stack;

/**
 * Created by raghu on 12/25/2016.
 */
public class ReverseStackWD {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        new ReverseStackWD().reverseStack(s);
        System.out.println(s);
    }

    public void reverseStack(Stack<Integer> s)
    {
     if(s.isEmpty())
     {
         return;
     }
     int item = s.pop();
     reverseStack(s);
     reverseStackBottom(s, item);
    }

    public void reverseStackBottom(Stack<Integer> s, int item)
    {
        if(s.isEmpty())
        {
            s.push(item);
            return;
        }
        int popItem = s.pop();
        reverseStackBottom(s, item);
        s.push(popItem);
    }

}
