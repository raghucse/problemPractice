package com.neu.CCI.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by raghu on 1/2/2017.
 * 4.7 Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 projects, where thesecond projectis dependent on the frst project). All of a project's dependencies
 must be built before the project is. Find a build order that will allow the projects to be built. If there
 is no valid build order, return an error
 */
public class BuildOrder {
    public static void main(String[] args) {
        int a[][] = new int[5][];
        a[0] = new int[]{4};
        a[1] = new int[]{0};
        a[2] = new int[]{0};
        a[3] = new int[]{1,2};
        a[4] = new int[]{};


    }

    public void buildOrder(int a[][]) throws Exception
    {
        HashSet<Integer> temp = new HashSet<>();
        HashSet<Integer> perm = new HashSet<>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i< a.length ;i++)
        {
            if(!perm.contains(i))
            {
                visit(i,a,temp,perm,result);
            }
        }

    }


    public void visit(int i, int a[][], HashSet<Integer> temp, HashSet<Integer> perm, List<Integer> result) throws Exception
    {

        if(temp.contains(i)) throw new Exception();
        if(!perm.contains(i))
        {
            temp.add(i);
            for(int j: a[i])
            {
                visit(j, a, temp, perm, result);
            }
            perm.add(i);
            temp.remove(i);
            result.add(i);
        }
    }
}
