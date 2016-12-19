package com.neu;

/**
 * Created by raghu on 12/15/2016.
 */


public class DeleteMiddleNode {

    public static void main(String[] args) {

        Node n = new Node(1);
        Node temp = n;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        Node c = n.next;
        n = n.next;
        n.next = new Node(4);
        n = n.next;
        n.next = new Node(5);

        n = n.next;
        n.next = new Node(6);
        n = n.next;
        n.next = new Node(7);
        DMN(c);
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void DMN(Node c)
    {
        c.data = c.next.data;
        c.next = c.next.next;

    }

}
