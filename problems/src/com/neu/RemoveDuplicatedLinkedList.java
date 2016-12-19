package com.neu;

/**
 * Created by raghu on 12/15/2016.
 */




public class RemoveDuplicatedLinkedList {
    public static void main(String[] args) {

        Node n = new Node(6);
        Node temp = n;
        n.next = new Node(1);
        n = n.next;
        n.next = new Node(1);
        n = n.next;
        n.next = new Node(7);
        n = n.next;
        n.next = new Node(6);

        n = n.next;
        n.next = new Node(7);
        n = n.next;
        n.next = new Node(8);
        removeDups(temp);


    }

    public  static void removeDups(Node n){
        Node cur = null;
        Node next = null;
        Node temp = n;

        while(temp != null)
        {
            cur = temp;
            next = temp.next;

            while (next != null)
            {
                if(next.data == temp.data)
                {
                   cur.next =  next.next;
                   next = next.next;
                }
                else {
                    next = next.next;
                    cur = cur.next;
                }
            }
            temp = temp.next;

        }

        while (n != null)
        {
            System.out.println(n.data);
            n = n.next;
        }

    }
}
