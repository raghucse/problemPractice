package com.neu.CCI.TreesAndGraphs;

/**
 * Created by raghu on 1/1/2017.
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height
 */

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data)
    {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

public class MinimalTree {
    public static void main(String[] args) {
		int a[] = new int[]{1,2,3,4,5,6,7};
		TreeNode n =new MinimalTree().minimalTree(a, 0, a.length -1);
        if(n != null)
        //print not working
        new MinimalTree().printTree(n);
        else System.out.println("n is null");




    }

    public TreeNode minimalTree(int a[], int start, int end)
    {
        if(end < start)
			return null;
		
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(a[mid]);
		
		n.left = minimalTree(a, start, mid-1);
		n.right = minimalTree(a, mid+1,end);
		return n;
    }

    public void printTree(TreeNode n)
    {
        if(n == null)
            return;;

        printTree(n.left);
        System.out.print(" /");
        System.out.print(n.data);
        System.out.print(" \\");
        printTree(n.right);
        System.out.println();
    }
}
