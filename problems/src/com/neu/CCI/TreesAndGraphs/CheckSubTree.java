package com.neu.CCI.TreesAndGraphs;

/**
 * Created by raghu on 1/2/2017.
 */
public class CheckSubTree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {
    }

    public Boolean checkSubTree(TreeNode a, TreeNode b)
    {
        if(a == null)
            return false;

        if(a.val == b.val && isSameTree(a,b) == 1)
            return true;

        return checkSubTree(a.left, b) || checkSubTree(a.right,b);


    }

    public int isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b == null)
            return 1;

        if(a == null || b == null)
            return 0;

        if(a.val != b.val)
            return 0;

        if ( isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right) == 1)
            return 1;
        else
            return 0;

    }
}
