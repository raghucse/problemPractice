package com.neu.IB.Trees;

/**
 * Created by raghu on 1/2/2017.
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */



public class TreePathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int hasPathSum(TreeNode a, int b) {

        if(a == null)
            return 0;

        int currSum  = 0;
        return hasPathSum(a, b, currSum, null);
    }

    private int hasPathSum(TreeNode n, int b, int currSum, TreeNode prev)
    {

        if(n == null)
        {
            if(currSum == b && prev.left == null && prev.right == null)
                return 1;
            else
                return 0;
        }

        currSum += n.val;


        int left = hasPathSum(n.left, b, currSum, n);
        if(left == 1)
            return 1;

        int right = hasPathSum(n.right, b, currSum, n);
        if(right == 1)
            return 1;


        return 0;
    }
}
