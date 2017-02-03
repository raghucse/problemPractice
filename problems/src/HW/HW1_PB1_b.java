package HW;

/**
 * Created by raghu on 1/15/2017.
 */
/*
class Node{
    Node next;
    int data;
    Node(int data)
    {
        this.data = data;
    }
}
*/

public class HW1_PB1_b {

    public static void main(String[] args) {
        //1st Linked List
        Node An1 = new Node(1);
        Node An2 = new Node(2);
        An1.next = An2;
        Node An3 = new Node(3);
        An2.next = An3;
        Node An4 = new Node(4);
        An3.next = An4;
        Node An5 = new Node(5);
        An4.next = An5;

        //2nd Linked List
        Node Bn1 = new Node(11);
        Node Bn2 = new Node(22);
        Bn1.next = Bn2;
        Node Bn3 = new Node(33);
        Bn2.next = Bn3;
        Node Bn4 = new Node(44);
        Bn3.next = Bn4;

        int a[] = {2,3,4};
        int b = a.length;

        An5.next = Bn3;

        Node commonNode = new HW1_PB1_b().firstCommonElement(An1, Bn1);

        if(commonNode == null)
        {
            System.out.println("No common element");
        }
        else
        {
            System.out.println(commonNode.data);
        }
    }

    public Node firstCommonElement(Node headA, Node headB)
    {
        if(headA == null || headB == null)
        {
            return null;
        }

        int m =  getListLength(headA);
        int n =  getListLength(headB);

        //update longer list to match lenght of shorter list
        if(m > n)
        {
            headA = updateHead(headA, m-n);
        }
        else
        {
            headB = updateHead(headB, n-m);
        }

        //check for common element update both list the same time
        while ((headA != headB) && headA != null)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    //move head by x steps
    private Node updateHead(Node head, int x)
    {
        while(x>0)
        {
            x = x-1;
            head = head.next;
        }
        return head;
    }

    //return length of list
    private int getListLength(Node head)
    {
        int count = 0;
        while (head != null)
        {
            head =  head.next;
            count++;
        }
        return count;
    }
}
