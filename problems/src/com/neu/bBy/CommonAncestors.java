package com.neu.bBy;

import java.util.*;
import java.util.Stack;

/**
 * Created by raghu on 12/28/2016.
 */
public class CommonAncestors {
    Boolean first = false;
    Boolean second = false;
    TreeNode common;
    public static void main(String[] args) {

        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.left =  new TreeNode(6);

       CommonAncestors ca =  new CommonAncestors();
        int a = 3;
        int b = 6;
       Stack<TreeNode> sa = ca.commonAncestors(a, t);
        Stack<TreeNode> sb = ca.commonAncestors(b, t);

        if(sa == null || sb == null)
        {
            System.out.println("not found");
        }

        TreeNode prev = null;

        while (!sa.isEmpty() && !sb.isEmpty())
        {
            TreeNode curr = sa.pop();
            if(curr == sb.pop())
            {
                prev = curr;
            }
            else
            {
                break;
            }
        }

        System.out.println(prev.data);
    }

    public Stack<TreeNode> commonAncestors(int a, TreeNode n)
    {
        if(n == null) return null;
        if(n.data == a)
        {
          Stack<TreeNode> newStack = new Stack<TreeNode>();
          newStack.push(n);
            return newStack;
        }

        Stack<TreeNode> sLeft = commonAncestors(a, n.left);
        Stack<TreeNode> sRight = commonAncestors(a, n.right);

        if(sLeft != null)
        {
            sLeft.push(n);
            return sLeft;
        }

        if(sRight != null)
        {
            sRight.push(n);
            return sRight;
        }

        return null;
    }
}
