package com.neu;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by raghu on 12/17/2016.
 */
public class DeleteMiddleTest {
    @Test
    public void testDMN()
    {
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

        DeleteMiddleNode.DMN(c);

        StringBuilder data = new StringBuilder();

        while (temp != null)
        {
            data.append(temp.data);
            temp = temp.next;
        }

        Assert.assertEquals(data.toString(), "124567");
    }

}
