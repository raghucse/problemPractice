package com.neu;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by raghu on 11/21/2016.
 * Arrange given numbers to form the biggest number
 */
public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(8);
        a.add(89);

     //   System.out.println(numbers.toString());
   /*
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (String.valueOf(o1)+String.valueOf(o2)).compareTo(String.valueOf(o2)+String.valueOf(o1));
            }
        });*/


        Collections.sort(a, (Integer o1, Integer o2) -> {return (String.valueOf(o1)+String.valueOf(o2)).compareTo(String.valueOf(o2)+String.valueOf(o1));} );



        StringBuilder s = new StringBuilder();


        Boolean isZero = true;
        for (int i=a.size()-1;i>=0;i--) {
            if (a.get(i) != 0)
            {
                isZero = false;
            }
            s.append(String.valueOf(a.get(i)));

        }

        if (isZero)
        {
            System.out.println(String.valueOf(0));
        }
        else
            System.out.println(s.toString());


    }
}
