package com.neu;

/**
 * Created by raghu on 12/15/2016.
 */
public class KtoLast {
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

        ktolast(6, temp);
    }

    public static void ktolast(int k, Node n)
    {
        Node temp = n;
        int count = 0;
        while (temp != null)
        {
            count ++;
            temp = temp.next;
        }
      //  System.out.println(count);
        int position = Math.abs(count - k) +1;
        count = 0;
        while(n != null)
        {
            count ++;
            if(count == position)
            {
                System.out.println(n.data);
            }
            n = n.next;
        }


    }
}
