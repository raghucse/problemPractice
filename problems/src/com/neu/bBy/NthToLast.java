package com.neu.bBy;

/**
 * Created by raghu on 12/18/2016.
 */
class Node {
    int data;
    Node next= null;

    Node(int data) {
        this.data = data;
    }
}


public class NthToLast {
    private int count = 0;
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

    //    new KthToLast().kthLast(temp, 1);
        new NthToLast().kthLastOptimised(temp, 2);
    }

    public void kthLast(Node n, int pos)
    {
        if(n == null)
        {
            return;
        }
        Node temp = n;
        n = n.next;
        kthLast(n, pos);
        count ++;
        if(count == pos)
        {
            System.out.println(temp.data);
        }
    }

    //Simply superb and amazing technique
    //Time Complexity
    //
    public void kthLastOptimised(Node n, int pos)
    {
        Node cur = n;
        Node follow = n;

        for(int i=0 ; i<pos;i++)
        {
            if(cur == null)
            {
                return;
            }
            cur = cur.next;
        }

        while (cur != null)
        {
            cur = cur.next;
            follow = follow.next;
        }
        System.out.println(follow.data);
    }
}
