package com.neu.CCI.TreesAndGraphs;



/**
 * Created by raghu on 1/2/2017.
 * Common Ancestor of binary tree without extra datastructure
 */
public class CommonAncestor {

    public static void main(String[] args) {
        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        TreeNode p = t.left.right;
        TreeNode q = t.left.left;

        t.right.left =  new TreeNode(6);

        System.out.println((new CommonAncestor().findAncestors(t,p,q)));


    }

    public TreeNode findAncestors(TreeNode n, TreeNode p, TreeNode q)
    {
        if(n == null || p ==null || q==null)
        {
            return null;
        }

        Boolean pLeftCheck = checkNode(n.left,p);
        Boolean qLeftCheck = checkNode(n.left,q);

        if(pLeftCheck != qLeftCheck)
        {
            return n;
        }

        TreeNode next = pLeftCheck ? n.left : n.right;

        return findAncestors(next, p, q);
    }

    public Boolean checkNode(TreeNode n, TreeNode p)
    {
        if(n == null)
        {
            return false;
        }

        if(n == p)
            return true;

        return (checkNode(n.left, p)) || (checkNode(n.right, p));
    }


}
