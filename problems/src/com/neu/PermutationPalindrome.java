package com.neu;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by raghu on 12/12/2016.
 */
public class PermutationPalindrome {
    public static void main(String[] args) {
        String s = "TactCoa".toLowerCase();
        String split[] =  s.split("");
        Set<String> uniqueString = new HashSet<>();
        uniqueString.addAll(Arrays.asList(split));
        Map<String,Integer> a = new HashMap<>();
        System.out.println(split.length);
        for (String s1: split) {
            if(a.containsKey(s1))
            {
                int count = a.get(s1)+1;
                a.put(s1, count);
            }
            else
            {
                a.put(s1, 1);
            }
        }
        Boolean odd = false;
        Boolean isPal = true;
        System.out.println(a);
        for (Map.Entry<String, Integer> e: a.entrySet()) {
            if(e.getValue() % 2 != 0)
            {
                if(odd == false)
                {
                    odd = true;
                }
                else
                {
                    isPal = false;
                }
            }
        }
        System.out.println(isPal);
    }
}
