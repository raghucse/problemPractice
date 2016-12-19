package com.neu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by raghu on 12/14/2016.
 */
public class LongSubStringV2 {
    public static void main(String[] args) {
        LongSubStringV2 t = new LongSubStringV2();
        System.out.println(t.lengthOfLongestSubstring("anviaj"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
        {
            return 0;
        }

        String sa[] = s.split("");
        StringBuilder sb = new StringBuilder();
        int maxLength =0;
        int i=0;
        int j = 0;

            while(j < sa.length)
            {
              //  System.out.println(" j: "+j+" string: "+sb.toString());
                if(! sb.toString().contains(sa[j]))
                {
                    sb.append(sa[j]);
                    j = j+1;
                }
                else
                {
                //    System.out.println(sb.toString());
                    int sbLenght = sb.toString().length();
                    if(sbLenght > maxLength)
                    {
                        maxLength = sbLenght;
                    }
                    sb = new StringBuilder();
                    if(j < sa.length-1 && !(sa[j].equals(sa[j-1])))
                        j = j-1;
                }
            }


        int sbLenght = sb.toString().length();
        if(sbLenght > maxLength)
        {
            maxLength = sbLenght;
        }
        return maxLength;
    }
}
