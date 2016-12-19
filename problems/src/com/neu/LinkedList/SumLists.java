package com.neu.LinkedList;

/**
 * Created by raghu on 12/17/2016.
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;

    }
}


public class SumLists {

    public static void main(String[] args) {
        Node n = new Node(7);
        Node n1 = n;
        n.next = new Node(1);
        n = n.next;
       // n.next = new Node(6);


        Node t = new Node(5);
        Node n2 = t;
        t.next = new Node(9);
        t = t.next;
        t.next = new Node(2);

        SumLists s = new SumLists();

        System.out.println(s.sumLists(n1, n2));
        //System.out.println(s.sumLists2(n1, n2));
    }


    public int sumLists(Node n1, Node n2)
    {
        int num1=getNum(n1),num2=getNum(n2);
        return num1+num2;
    }

    public int sumLists2(Node n1, Node n2)
    {
        int num1=getNum1(n1, length(n1)),num2=getNum1(n2,length(n2));
        return num1+num2;
    }


    public int getNum(Node n1)
    {
        int count =0;
        int num1 = 0;
        while (n1 != null)
        {
            int multiplier =(int) Math.pow(10,count);
            num1 = num1 + (multiplier * n1.data);
            count++;
            n1 = n1.next;
        }

        return num1;
    }

    public int getNum1(Node n1, int lenght)
    {
        int num1 = 0;
        while (n1 != null)
        {
            int multiplier =(int) Math.pow(10,lenght);
            num1 = num1 + (multiplier * n1.data);
            System.out.println(num1);
            lenght--;
            n1 = n1.next;
        }
        return num1;
    }

    public int length(Node n1)
    {
        Node temp  = n1 ;
        int count =0;
        while (temp != null)
        {
            count ++;
            temp = temp.next;
        }
        //System.out.println(count);
        return count-1;
    }
}

