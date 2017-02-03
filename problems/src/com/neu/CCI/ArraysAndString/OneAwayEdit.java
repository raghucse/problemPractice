package com.neu.CCI.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by raghu on 1/12/2017.
 */
public class OneAwayEdit {
    public static void main(String[] args) {

    }

    public Boolean oneAwayEdit(String s1, String s2)
    {
        if(s1.length() == s2.length())
        {
            if(s1.equals(s2))
            {
                return false;
            }
            else
                return checkOneflip(s1, s2);
        }
        return false;
    }

    public Boolean checkOneflip(String s1, String s2)
    {
        ArrayList<Character> container = new ArrayList<>();

        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();

        for(char c : s1s)
        {
            container.add(c);
        }


        for(char c : s2s)
        {
            container.remove(c);
        }

        return container.size() == 2 ? true: false;
    }

}
