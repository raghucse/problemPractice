package com.neu.CCI.TreesAndGraphs;

/**
 * Created by raghu on 1/1/2017.
 * 4.5: Validate BST: Implement a function to check if a binary tree is a binary search tree
 */
public class ValidBST {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);


        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        TreeNode n1 = new TreeNode(1);
        n5.left = n2;
        n2.left = n1;
        n3.right = n3;

        TreeNode n7 = new TreeNode(5);


        TreeNode n8 = new TreeNode(8);
        n8.data = 8;

        TreeNode n6 = new TreeNode(6);
        n6.data = 6;

        n5.right = n7;
        n7.left = n6;
        n7.right = n8;

       // System.out.println((new ValidBST().validBst(n5, Integer.MIN_VALUE, Integer.MAX_VALUE)));

       System.out.println((new ValidBST().validBstMy(n5)));
    }

    public Boolean validBst(TreeNode n, int min, int max)
    {
        if(n == null)
            return true;

        if(n.data < min || n.data > max) return false;

        return (validBst(n.left,min, n.data) && validBst(n.right, n.data,max));
    }

    public Boolean validBstMy(TreeNode n)
    {
        if(n == null)
            return true;

        if((n.left != null && n.left.data > n.data) || (n.right != null && n.right.data < n.data) )
        {
            return false;
        }
        if(!validBstMy(n.left))
            return false;

        if(!validBstMy(n.right))
            return false;

        return true;

    }

}
