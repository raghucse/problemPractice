package com.neu.byteBybyte;

/**
 * Created by raghu on 12/24/2016.
 * https://www.youtube.com/watch?v=aVFWW3pBQFo&index=22&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj
 */
public class LongestSubString {
    public static void main(String[] args) {
        System.out.println((new LongestSubString().longestSubString("ABAA", "BABAA")));
    }

    public String longestSubString(String s1, String s2)
    {
        if(s1.length()==0 || s2.length() == 0)
        {
            return "";
        }

        int[][] dynamo = new int[s1.length()][s1.length()];
        String longest = "";


        for(int i = 0 ; i< s1.length(); i++)
        {

            for(int j=0; j<s1.length(); j++)
            {
                if(s1.charAt(i) == s1.charAt(j))
                {
                    if(i==0 || j==0)
                    {
                        dynamo[i][j] = 1;
                    }
                    else
                    {
                        dynamo[i][j] = dynamo[i-1][j-1] +1;
                        if(dynamo[i][j] > longest.length())
                        {

                            int beginIndex = i-(dynamo[i][j]-1);
                            int endIndex = i+1;
                            longest =  s1.substring(beginIndex, endIndex);
                        }
                    }


                }
            }

        }

        return longest;
    }

}
