package com.neu.byteBybyte;

/**
 * Created by raghu on 12/27/2016.
 */


public class TreeToLinkedList {
    public static void main(String[] args) {
        //new TreeToLinkedList().treeToList();
        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.left =  new TreeNode(6);

        TreeNode linkedList = new TreeToLinkedList().treeToList(t);


        while (linkedList != null)
        {
            System.out.println(linkedList.data);
            linkedList = linkedList.right;
        }
    }

    public TreeNode concatenate(TreeNode a, TreeNode b)
    {
        if(a == null) return b;
        if(b == null) return a;

        TreeNode aEnd = a.left;
        TreeNode bEnd = b.left;

        a.left = bEnd;
        bEnd.right = a;
        //aEnd.left = b;

        //Think this must be
         aEnd.right = b;

        b.left = aEnd;
        return a;
    }

    public TreeNode treeToList(TreeNode n)
    {
        if(n == null) return n;
        TreeNode leftList = treeToList(n.left);
        TreeNode rightList = treeToList(n.right);

        n.left = n;
        n.right = n;

        n = concatenate(leftList, n);
        n = concatenate(n, rightList);
        return n;

    }
}
