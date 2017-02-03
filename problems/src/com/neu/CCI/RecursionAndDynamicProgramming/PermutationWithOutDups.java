package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Created by raghu on 1/8/2017.
 */
public class PermutationWithOutDups {
    public static void main(String[] args) {
        System.out.println(new PermutationWithOutDups().computePermutation("Raghu"));
    }

    public ArrayList<String> computePermutation(String str)
    {
        if(str  == null)
        {
            return null;
        }

        ArrayList<String> permutations =  new ArrayList<>();;
        if(str.length() == 0)
        {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String subString = str.substring(1);
        ArrayList<String> words =  computePermutation(subString);

        for(String s : words)
        {
            for(int i = 0; i<= s.length(); i++)
            {
                String newStr = insertChar(first, s, i);
                permutations.add(newStr);
            }

        }
        return permutations;

    }

    public String insertChar(char c, String s, int i)
    {
        String start = s.substring(0,i);
        String end = s.substring(i);
        return start + c + end;
    }

}
