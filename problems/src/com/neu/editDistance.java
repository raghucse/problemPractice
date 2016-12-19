package com.neu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.SocketHandler;

/**
 * Created by raghu on 12/12/2016.
 */
public class editDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String m = sc.nextLine();
        System.out.println("Enter the second string:");
        String n = sc.nextLine();

        String mArray[] = m.split("");
        String nArray[] = n.split("");

        Boolean isEd =  checkEd(mArray,nArray);
        System.out.println(isEd);
    }

    static  Boolean checkEd(String m[], String n[])
    {
        if(Math.abs(m.length - n.length) > 1)
        {
            return false;
        }
        else if(m.length == n.length)
        {
            int count = 0;
            for(int i =0 ; i< m.length;i++)
            {
                if(!m[i].equals(n[i]))
                {
                    System.out.println(m[i] +" "+n[i]);
                    count++;
                }
                if(count>1)
                {
                    System.out.println(count);
                    return false;
                }

            }
        }
        else
        {
            int minLenght = Math.min(m.length,n.length);
            String minLengthArray[] = null;
            String maxLengthArray[] = null;

            if(m.length == minLenght)
            {
                minLengthArray = m;
                maxLengthArray = n;

            }
            else
            {
                maxLengthArray = m;
                minLengthArray = n;
            }

            int i = 0;
            int j = 0;
            int count = 0;
            while(i < minLenght && j < maxLengthArray.length)
            {
                if(!minLengthArray[i].equals(maxLengthArray[j]))
                {
                   // System.out.println();
                    j++;
                    count++;
                    if(count>1)
                    {
                        return false;
                    }
                }
                else
                {
                    i++;
                    j++;
                }
            }


        }
        return true;

    }
}
