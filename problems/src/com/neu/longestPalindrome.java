package com.neu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by raghu on 12/15/2016.
 */
public class longestPalindrome {

    public static void main(String[] args) {
        longestPalindrome l = new longestPalindrome();
        System.out.println(l.longestPalindrome("abcda"));
    }
    public String longestPalindrome(String s) {
        String sArray[] = s.split("");
        int max_length = 0;
        String maxPalin = "";
        if(s.length() == 1)
        {
            return s;
        }


        for(int i=0;i<sArray.length;i++) {
            String firstChar = sArray[i];
            //  System.out.println(firstChar);

            String sub = s.substring(i + 1);
            //  System.out.println(sub);
            List<Integer> indexes = new ArrayList<>();
            int pos = sub.indexOf(firstChar);
            if(pos!= -1) {
                indexes.add(pos);
                while (pos >= 0) {
                    //     System.out.println(pos);
                    pos = sub.indexOf(firstChar, pos + 1);
                    if(pos!= -1) {
                        indexes.add(pos);
                    }
                }
            }

            for (int index : indexes) {
                // System.out.println(pos);
                if((index + 1+1) > max_length) {
                    String sub2 = sub.substring(0, index + 1);
                    String subPalin = firstChar + sub2;
                    // System.out.println(subPalin);
                    // Boolean

                    Boolean val = palindrom(subPalin);

                    if (val) {
                        if (max_length < subPalin.length()) {
                            max_length = subPalin.length();
                            maxPalin = subPalin;
                        }
                    }
                }
            }
        }


        if(maxPalin.equals(""))
            return sArray[0];
        else
            return maxPalin;
    }

    public Boolean palindrom(String subPalin)
    {
        int i = 0;

        char palin[] = subPalin.toCharArray();
        int j = palin.length-1;
        while(i != j && i<j)
        {
            if(palin[i] != palin[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
