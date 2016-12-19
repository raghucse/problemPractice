package com.neu;

/**
 * Created by raghu on 12/13/2016.
 */
public class StringComparisionV2 {
    public static void main(String[] args) {
        String m = "abcdef";
        String mArray[] = m.split("");
        StringBuilder compressed = new StringBuilder();

        String prev;
        String cur;
        int count =1;
        int i;
        for( i=1; i<m.length();i++)
        {
            if(mArray[i].equals(mArray[i-1]))
            {
                count ++;
                if(i == m.length()-1)
                {
                    compressed.append(mArray[i]+""+count);
                }
            }
            else {
                compressed.append(mArray[i - 1] + "" + count);
                count = 1;
                if(i == m.length()-1)
                {
                    compressed.append(mArray[i]+""+count);
                }
            }
        }



        if(compressed.toString().length() > m.length())
        {
            System.out.println(m);
        }
        else {
            System.out.println(compressed.toString());
        }

    }
}
