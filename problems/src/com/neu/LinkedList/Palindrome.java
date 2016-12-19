package com.neu.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by raghu on 12/17/2016.
 */
public class Palindrome {
    public static void main(String[] args) {

        Node n = new Node(7);
        Node n1 = n;
        n.next = new Node(1);
        n = n.next;
     /*   n.next = new Node(6);
        n = n.next; */
        n.next = new Node(1);
        n = n.next;
     /*   n.next = new Node(7);
        n = n.next;*/

        System.out.println(new Palindrome().isPalindrome2(n1));
    }

    public void palindrome(Node n)
    {
        List<Integer> s = new ArrayList<>();

        while (n != null)
        {
            s.add(n.data);
            n = n.next;
        }

        System.out.println(isPalindrome(s));

    }

    Boolean isPalindrome(List s)
    {
        int i = 0;
        int j = s.size()-1;

        while (i != j && i < j)
        {
            if(s.get(i) != s.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public void reverse(Node n1)
    {
        Node head = new Node(0);
        while (n1 != null)
        {
            n1 = head.next;
            head = n1;

        }

    }

    public Boolean isPalindrome2(Node n1)
    {
        Node slow = n1;
        Node fast = n1;
        Stack<Integer> stak = new Stack<>();

        while(  fast != null && fast.next != null)
        {
            stak.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null)
        {
            slow = slow.next;
        }

        while (slow != null)
        {
            if(stak.pop() != slow.data )
            {
                return false;
            }
            slow = slow.next;
        }

       return true;
    }



}
