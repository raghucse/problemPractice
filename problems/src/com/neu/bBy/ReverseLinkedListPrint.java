package com.neu.bBy;

/**
 * Created by raghu on 12/24/2016.
 */
public class ReverseLinkedListPrint {
    Node head = null;
    public static void main(String[] args) {
        Node n = new Node(1);
        Node temp = n;
        n.next = new Node(2);
        n = n.next;
        n.next = new Node(3);
        n = n.next;
        n.next = new Node(4);

      // new ReverseLinkedListPrint().reverseLinkedListrecur(temp);

       ReverseLinkedListPrint LP = new ReverseLinkedListPrint();
        LP.reverseLinkedListreverse(temp, null);
        Node head = LP.head;
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public void reverseLinkedListrecur(Node n)
    {
        if(n == null)
        {
            return;
        }
        reverseLinkedListrecur(n.next);
        System.out.println(n.data);
    }

    public void reverseLinkedListreverse(Node cur, Node prev)
    {
        if(cur.next == null)
        {
            head = cur;
            cur.next = prev;
            return;
        }
        Node temp = cur.next;
        cur.next = prev;
        reverseLinkedListreverse(temp, cur);
    }

 /*   public void reverseLinkedListWhile(Node n)
    {
        while(n.next == null)
        Node temp = cur.next;
        cur.next = prev;
        reverseLinkedListreverse(temp, cur);
    } */
}
