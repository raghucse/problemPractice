package com.neu.CCI.TreesAndGraphs;



import java.util.Random;

/**
 * Created by raghu on 1/2/2017.
 */
public class RandomNode {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int children;
    }


    private TreeNode root;
    Random randomGen;
    public static void main(String[] args) {

    }

    public TreeNode getRandom()
    {
        int rand = randomGen.nextInt(root.children+1);
        return getRandom(root, rand);
    }

    public TreeNode getRandom(TreeNode curr, int rand)
    {
        if(rand == children(curr.left)) return curr;
        if(rand < children(curr.left)) return getRandom(curr.left, rand);
        return getRandom(curr.left, rand - children(curr.left) - 1);

    }

    public int children(TreeNode n)
    {
        if(n == null) return 0;
        return n.children +1;
    }


}
