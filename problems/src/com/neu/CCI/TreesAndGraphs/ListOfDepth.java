package com.neu.CCI.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by raghu on 1/1/2017.
 */
public class ListOfDepth {
    public static void main(String[] args) {
        List<LinkedList> lists = new ArrayList<LinkedList>();

        TreeNode t =  new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        t.right.left =  new TreeNode(6);
		
        new ListOfDepth().listOfDepth(t, 0, lists);
        System.out.println(lists);


    }

    public void listOfDepth(TreeNode n, int level, List<LinkedList> lists)
    {
		if(n == null)
			return;
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level)
		{
			list = new LinkedList<TreeNode>();
			
			lists.add(list);
		}
		else
		{
			list = lists.get(level);
		}
		
		list.add(n);
		
		listOfDepth(n.left, level+1, lists);
		listOfDepth(n.right, level+1, lists);
    }
}
