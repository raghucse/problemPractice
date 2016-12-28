package com.neu.bBy;

/**
 * Created by raghu on 12/25/2016.
 */
public class LongestConsecutiveBranch {
    public static void main(String[] args) {

        TreeNode t = new TreeNode(0);
        t.right =  new TreeNode(2);
        t.right.left = new TreeNode(1);
        t.right.right = new TreeNode(3);

        t.left =  new TreeNode(1);
        t.left.right = new TreeNode(2);
        t.left.left = new TreeNode(1);

        System.out.println(new LongestConsecutiveBranch().longestConsesutiveBranch(t));

    }

    public int longestConsesutiveBranch(TreeNode n)
    {
        if(n == null)
            return 0;

        return Math.max(longestConsesutiveBranch(1,n.data,n.left), longestConsesutiveBranch(1,n.data,n.right));
    }

    public int longestConsesutiveBranch(int length, int prev, TreeNode n)
    {
        if(n == null)
            return length;

        if(n.data == prev +1)
        {
            int rl = longestConsesutiveBranch(length+1, n.data, n.right);
            int ll = longestConsesutiveBranch(length+1, n.data, n.left);
            return Math.max(rl,ll);
        }
        else
        {
            int rl = longestConsesutiveBranch(1, n.data, n.right);
            int ll = longestConsesutiveBranch(1, n.data, n.left);
            return Math.max(rl,ll);
        }


    }
}
