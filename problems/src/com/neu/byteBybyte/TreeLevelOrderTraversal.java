package com.neu.byteBybyte;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by raghu on 12/21/2016.
 */
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}


public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.left =  new TreeNode(6);

        new TreeLevelOrderTraversal().traverseTree(t);

    }

    public void traverseTree(TreeNode tree)
    {
        if(tree == null)
        {
            return;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(tree);
        while (!q.isEmpty())
        {
            TreeNode curr = q.remove();
            System.out.print(curr.data+" ");
          if(curr.left != null)
            q.add(curr.left);
          if(curr.right != null)
            q.add(curr.right);
        }
    }
}
