package com.neu.byteBybyte;


import java.util.Stack;
/**
 * Created by raghu on 12/22/2016.
 */
public class LinekdListPalindrome {
    public static void main(String[] args) {
        Node n = new Node(1);
        Node temp = n;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(4);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(1);

        System.out.println(new LinekdListPalindrome().linkedListPlaindrome(temp));
    }

    public Boolean linkedListPlaindrome(Node n)
    {
        Stack<Integer> stack =new  Stack<Integer> ();
        Node runner  = n;

        while(runner != null && runner.next != null)
        {
            stack.push(n.data);
            n = n.next;
            runner = runner.next.next;
        }

        if(runner != null)
        {
            n =  n.next;
        }

        while (n != null)
        {
            int popElement = stack.pop();
            if(n.data !=  popElement)
            {
                return false;
            }
            n = n.next;
        }
        return true;

    }
}
