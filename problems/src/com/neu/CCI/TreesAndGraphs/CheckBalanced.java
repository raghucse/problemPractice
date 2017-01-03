package com.neu.CCI.TreesAndGraphs;

/**
 * Created by raghu on 1/1/2017.
 * 4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 node never diﬀer by more than one.
 */
public class CheckBalanced {
    public static void main(String[] args) {
        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.left =  new TreeNode(6);

        System.out.println(new CheckBalanced().checkBalanced(t));



    }

    public int checkBalanced(TreeNode n)
    {
        if(n == null)
            return 0;

        int left = checkBalanced(n.left);
        if(left == -1)
        {
            return -1;
        }

        int right = checkBalanced(n.right);
        if(right == -1)
        {
            return -1;
        }

        int diff =  Math.abs(left - right);

        if(diff > 1)
        {
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
