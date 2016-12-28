package com.neu.byteBybyte;

import java.util.*;

/**
 * Created by raghu on 12/27/2016.
 */

class graphNode{
    int data;
    List<graphNode> next;
    graphNode(int data)
    {
        this.data = data;
    }
}

public class ShortestPath {
    public static void main(String[] args) {
        graphNode n1 = new graphNode(1);
        graphNode n2 = new graphNode(2);
        graphNode n3 = new graphNode(3);
        graphNode n4 = new graphNode(4);
        graphNode n5 = new graphNode(5);

        List<graphNode> nextList = new ArrayList<>();
        nextList.add(n2);
        nextList.add(n3);
        n1.next = nextList;

        nextList = new ArrayList<>();
        nextList.add(n5);

        n2.next = nextList;

        nextList = new ArrayList<>();
        nextList.add(n3);
        nextList.add(n1);

        n4.next = nextList;

        nextList = new ArrayList<>();
        nextList.add(n4);

        n5.next = nextList;

        List<graphNode> out = new ShortestPath().shortedtPath(n2, n3);

        if(out == null)
        {
            System.out.println("No path");
        }
        else {
            for (graphNode g : out) {
                System.out.println(g.data);
            }
        }

    }

    public List<graphNode> shortedtPath(graphNode a, graphNode b)
    {
        if( a == null || b == null || a.next == null) return null;

        Queue<graphNode> bsf = new LinkedList<>();
        Map<graphNode, graphNode> mapper = new HashMap<>();

        bsf.add(a);
        mapper.put(a,null);

        while (!bsf.isEmpty())
        {
            graphNode curr = bsf.remove();

            if(curr == b) break;

            for(graphNode g: curr.next)
            {
                bsf.add(g);
                mapper.put(g, curr);
            }

        }

        if(mapper.get(b) == null) return null;
        List<graphNode> out = new ArrayList<>();
        graphNode curr = b;

        while (curr != null)
        {
            out.add(curr);
            curr = mapper.get(curr);
        }
        return out;
    }
}

