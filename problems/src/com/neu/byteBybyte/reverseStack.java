package com.neu.byteBybyte;

import java.util.Stack;

/**
 * Created by raghu on 12/18/2016.
 * Solved used two recursion
 * One to access the  elements from the bottom
 * Second to push the elements to the bottom
 */

/* Time complexity
   O(n) = insertAtBottom
   O(n^2) = reverse

   space complexity
   O(n) +O(n) = reverse The same space is used again and again


 */

public class reverseStack {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        System.out.println(s);
        new reverseStack().reverse(s);
        System.out.println(s);

    }

    public Stack<Integer> reverse(Stack<Integer> s)
    {
        if(s.empty())
        {
            return s;
        }
        int temp = s.pop();
        reverse(s);
        insertAtBottom(s, temp);
        return s;
    }

    private void insertAtBottom(Stack<Integer> s, int x)
    {
            if(s.empty())
            {
                s.push(x);
                return;
            }
            int temp = s.pop();
            insertAtBottom(s, x);
            s.push(temp);
    }

}


