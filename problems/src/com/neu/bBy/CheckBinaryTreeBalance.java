package com.neu.bBy;

import com.neu.*;

/**
 * Created by raghu on 1/1/2017.
 */
public class CheckBinaryTreeBalance {
    public static void main(String[] args) {

        TreeNode t =  new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(2);
        t.right.left =  new TreeNode(4);
    //    t.right.left.right =  new TreeNode(6);

        int result = new CheckBinaryTreeBalance().checkBinaryTreeBalance(t);
        if(result == -1)
            System.out.println("Not height balanced");
        else
            System.out.println("height balanced");
    }

    public int checkBinaryTreeBalance(TreeNode n)
    {
        if(n == null)
            return 0;

        int left = checkBinaryTreeBalance(n.left);
        if(left == -1)
            return -1;

        int right = checkBinaryTreeBalance(n.right);
        if(right == -1)
            return -1;

        int diffHeight = Math.abs(left - right);

        if(diffHeight > 1)
        {
            return -1;
        }

        return 1+Math.max(left, right);
    }
}
