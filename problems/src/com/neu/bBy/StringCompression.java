package com.neu.bBy;

/**
 * Created by raghu on 12/18/2016.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println( new StringCompression().stringCompressionV2("dbbbb"));
    }

    public String stringCompression(String s)
    {
    //    char[] sa = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        if(s.length() == 1)
        {
            return sb.append(s).append(1).toString();
        }

        int i=0;
        int count = 1;
        //System.out.println(sa.length);
        for(i = 1; i<s.length();i++)
        {
            if(s.charAt(i) == s.charAt(i-1))
            {
          //      System.out.println(sa[i]+ " "+ sa[i-1]+" "+count);
                count ++;
            }
            else
            {
             //   System.out.println(sa[i]+ " "+ sa[i-1]+" "+count);
                sb.append(s.charAt(i-1)).append(count);
                count = 1;
            }
        }

        sb.append(s.charAt(i-1)).append(count);
        //also check for length begin same after compression
        return sb.toString();

    }

    public String stringCompressionV2(String s)
    {
        //    char[] sa = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        if(s.length() == 1)
        {
            return sb.append(s).append(1).toString();
        }

        //int i=0;
        int count = 1;
        //System.out.println(sa.length);
        for(int i = 0; i<s.length()-1;i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                //      System.out.println(sa[i]+ " "+ sa[i-1]+" "+count);
                count ++;
            }
            else
            {
                //   System.out.println(sa[i]+ " "+ sa[i-1]+" "+count);
                sb.append(s.charAt(i)).append(count);
                count = 1;
            }
        }

        sb.append(s.charAt(s.length()-1)).append(count);
        return sb.toString();

    }
}
