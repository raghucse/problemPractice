package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;

/**
 * Created by raghu on 1/6/2017.
 */
public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> ps = new ArrayList<>();
        ps.add(1);
        ps.add(2);
        ps.add(3);
        System.out.println(new PowerSet().powerSet(ps,0));
    }

    public ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set,int index)
    {
        ArrayList<ArrayList<Integer>> allSubset;

        //add base case
        if(set.size() == index)
        {
            allSubset =  new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> subset =  new ArrayList<>();
            allSubset.add(subset);
        }
        else{
            allSubset = powerSet(set, index+1);
            int currentElement =  set.get(index);
            ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<>();
            for(ArrayList<Integer> s : allSubset)
            {
                ArrayList<Integer> newSub = new ArrayList<>();
                newSub.addAll(s);
                newSub.add(currentElement);
                moreSubSets.add(newSub);

            }
            allSubset.addAll(moreSubSets);

        }

        return allSubset;
    }


}
