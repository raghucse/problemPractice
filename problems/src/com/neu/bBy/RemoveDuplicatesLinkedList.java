package com.neu.bBy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by raghu on 12/28/2016.
 */
public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        Node n = new Node(1);
        Node temp = n;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(4);
        n = n.next;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(6);
        n = n.next;
        n.next = new Node(4);

        new RemoveDuplicatesLinkedList().WusingSet(temp);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }


    }

    public void usingSet(Node n)
    {
        Set<Integer> s = new HashSet<>();
        Node prev = null;

        while (n != null)
        {
            if(s.contains(n.data))
            {
                prev.next = n.next;
            }
            else
            {
                s.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public void WusingSet(Node n) {

        while (n != null) {
            Node temp = n.next;
            Node prev = n;
            while (temp != null)
            {

                if(temp.data == n.data)
                {
                    prev.next = temp.next;
                }
                else
                {
                    prev = temp;
                }
                temp =temp.next;
            }
            n = n.next;

        }

    }


}

