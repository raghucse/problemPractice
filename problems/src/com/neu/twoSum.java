package com.neu;

import java.util.*;

/**
 * Created by raghu on 12/14/2016.
 */
public class twoSum {
    public static void main(String[] args) {

        twoSum t = new twoSum();
        System.out.println(t.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        String sa[] = s.split("");

        Set<String> result = new HashSet<String>();
        result.addAll(Arrays.asList(sa));
        if(result.size() == s.length())
        {
            return s.length();
        }
        System.out.println(result);
        StringBuilder sb = new StringBuilder();


        for(String i: result)
        {
            sb.append(i);
        }

        String uniqueString = sb.toString();



        for(int i=0; i< uniqueString.length();i++)
        {
            String sub = uniqueString.substring(i);
            System.out.println(sub);
            if(s.contains(sub))
            {
               return uniqueString.length()-i;
            }
        }

        if(s.equals(""))
            return 0;
        else
            return -1;



    }
}
