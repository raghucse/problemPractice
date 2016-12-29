package com.neu.bBy;

import java.util.*;

/**
 * Created by raghu on 12/28/2016.
 */
public class BuildOrder {
    public static void main(String[] args) throws Exception{
        int a[][] = new int[5][];
        a[0] = new int[]{4};
        a[1] = new int[]{0};
        a[2] = new int[]{0};
        a[3] = new int[]{1,2};
        a[4] = new int[]{};

        new BuildOrder().buildOrder(a);
    }

    public void buildOrder(int[][] depen) throws  Exception
    {
        Set<Integer> perm = new HashSet<Integer>();
        Set<Integer> temp = new HashSet<Integer>();
        List<Integer> result = new LinkedList<>();

        for(int i = 0; i < depen.length; i++)
        {
            if(!perm.contains(i))
            {
                visit(i, depen, perm, temp, result);
            }
        }

        for(int i : result)
        {
            System.out.println(i);
        }

    }

    public void visit(int mod, int[][] depen, Set<Integer> perm, Set<Integer> temp, List<Integer> result) throws Exception
    {
        if(temp.contains(mod)) throw new Exception ();
        if(!perm.contains(mod))
        {
            temp.add(mod);
            for(int i: depen[mod])
            {
                visit(i, depen, perm, temp,result);
            }

            perm.add(mod);
            temp.remove(mod);
            result.add(mod);
        }

    }


}
