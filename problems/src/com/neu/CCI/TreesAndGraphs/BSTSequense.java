package com.neu.CCI.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by raghu on 1/2/2017.
 */
public class BSTSequense {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);


        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        TreeNode n1 = new TreeNode(1);
        n5.left = n2;
        n2.left = n1;
        n3.right = n3;

        TreeNode n7 = new TreeNode(7);


        TreeNode n8 = new TreeNode(8);
        n8.data = 8;

        TreeNode n6 = new TreeNode(6);
        n6.data = 6;

        n5.right = n7;
        n7.left = n6;
        n7.right = n8;

        System.out.println((new BSTSequense().bstSequence(n5)));
    }
		
	public ArrayList<LinkedList<Integer>> bstSequence(TreeNode n)
	{
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();

		if(n == null)
		{
			results.add(new LinkedList<Integer>());
			return results;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(n.data);

		ArrayList<LinkedList<Integer>> leftSubtree = bstSequence(n.left);
		ArrayList<LinkedList<Integer>> rightSubtree = bstSequence(n.right);

		for(LinkedList<Integer> lleft : leftSubtree)
			for(LinkedList<Integer> lright : rightSubtree)
			{
				ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();
				weave(lleft, lright, weave, prefix);
				results.addAll(weave);

			}

		return results;

	}	    

	public void weave(LinkedList<Integer> lleft, LinkedList<Integer> lright, ArrayList<LinkedList<Integer>> weave, LinkedList<Integer> prefix)
	{
		if(lleft.size() == 0 || lright.size() == 0)
		{
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			result.addAll(lleft);
			result.addAll(lright);
			weave.add(result);
			return;
		}

		int headLeft = lleft.remove();
		prefix.addLast(headLeft);
		weave(lleft,lright,weave,prefix);
		lleft.addFirst(headLeft);
		prefix.removeLast();

		int headRight = lright.remove();
		prefix.addLast(headRight);
		weave(lleft,lright,weave,prefix);
		lright.addFirst(headRight);
		prefix.removeLast();


	}

}
