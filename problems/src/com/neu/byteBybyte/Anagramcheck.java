package com.neu.byteBybyte;

/**
 * Created by raghu on 12/18/2016.
 */
public class Anagramcheck {
    public static void main(String[] args) {
        System.out.println(new Anagramcheck().anagramCheck("uppu","pupp"));
        //Shifts 8 times
        System.out.println(1<<8);
    }

    public Boolean anagramCheck(String s1, String s2)
    {
        String s11 =  s1.toLowerCase();
        String s22 = s2.toLowerCase();
        int charLen[] = new int[256];

        for(char c : s11.toCharArray())
        {
            charLen[c] ++;
        }

        for(char c : s22.toCharArray())
        {
            charLen[c] --;
        }

        for(int i :  charLen)
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;

    }
}
