package com.neu.bBy;

/**
 * Created by raghu on 12/31/2016.
 * Can be implemented using has set too
 */
public class ListCycle {
    public static void main(String[] args) {
        Node n = new Node(1);
        Node temp = n;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        Node n4 = new Node(4);
        n.next = n4;
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(2);
        n = n.next;
        n.next = n4;
        n = n.next;
        n.next = new Node(5);

        new ListCycle().listCycle(temp);


    }

    public void listCycle(Node n)
    {
        Node curr = n;
        Node runner = n.next;

        while (curr != null && runner != null)
        {

            if(curr == runner)
            {
                System.out.println("Cyle present");
                return;
            }

            curr = curr.next;
            if(null  != runner.next )
                runner = runner.next.next;
            else
                runner = runner.next;
        }

        System.out.println("Cycle not present");

    }

}
