package com.neu.bBy;

import java.util.Random;

/**
 * Created by raghu on 12/28/2016.
 */
class RBNode{
    RBNode left;
    RBNode right;
    int val;
    int children;
}

public class RandomBinaryTree {
    private RBNode root;
    private Random rand;

    public static void main(String[] args) {

    }

    public int  getRandomNode()
    {
        if(root == null) throw new NullPointerException();
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }

    private int getRandomNode(RBNode curr, int count)
    {
        if(count == children(curr.left)) return curr.val;
        if(count < children(curr.left)) return  getRandomNode(curr.left,count);
        return getRandomNode(curr.right, count-children(curr.left)-1);
    }

    public int children(RBNode n)
    {
        if(n == null) return 0;
        return n.children +1 ;
    }

}
