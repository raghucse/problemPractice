package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Created by raghu on 1/8/2017.
 */
public class Parens {
    public static void main(String[] args) {
        int n = 3;
        char[] str = new char[n*2];
        ArrayList<String> result = new ArrayList<>();
        new Parens().getParens(result, n, n, str, 0);
        System.out.println(result);

    }

    public void getParens(ArrayList<String> result, int left, int right, char str[], int index)
    {
        if(left< 0 || right < left) return;

        if(left == 0 && right ==0)
            result.add(String.copyValueOf(str));
        else
        {
            str[index] = '(';
            getParens(result, left-1,right, str,index+1);

            str[index] = ')';
            getParens(result, left,right-1, str,index+1);
        }
    }
}
