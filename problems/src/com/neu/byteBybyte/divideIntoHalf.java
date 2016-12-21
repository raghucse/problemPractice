package com.neu.byteBybyte;

/**
 * Created by raghu on 12/21/2016.
 */

public class divideIntoHalf {
    public static void main(String[] args) {
        Node n = new Node(1);
        Node temp = n;

        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(4);
        n = n.next;
        n.next = new Node(5);
        n = n.next;
        n.next = new Node(6);
        n = n.next;
        n.next = new Node(7);
        n = n.next;
        n.next = new Node(7);

        Node half = new divideIntoHalf().divideIntoHalf(temp);

        while (half != null)
        {
            System.out.println(half.data);
            half = half.next;
        }
    }

    public Node divideIntoHalf(Node n)
    {
        Node runner = n;

        while(runner != null  )
        {
            runner = runner.next;
            if(runner == null ) break;
            runner = runner.next;

            n = n.next;
        }

        return n.next;
    }
}
