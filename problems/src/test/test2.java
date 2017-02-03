package test;

import java.util.ArrayList;

/**
 * Created by raghu on 1/1/2017.
 */
public class test2 {
    public static void main(String[] args) {
        int n =6;
        String format = "%"+n+"s";

        String sx = "20";
        String sy = "30";
        System.out.println(sy.compareTo(sx));


        StringBuilder hash = new StringBuilder();
        for(int i=0 ; i < n ; i++)
        {
            hash.append("#");
            System.out.printf(format,hash.toString());
            System.out.println();

        }


        System.out.println((2147483647 % 1337));


        String s = "000";
        String s1 = "100";
        String s2 = "0101";
        String s3 = "001";

        System.out.println(Integer.parseInt(s)+" "+Integer.parseInt(s1)+" "+Integer.parseInt(s3));


        ArrayList<Integer> result = new ArrayList<>();

        result.add(1);
        result.add(2);
        result.add(3);
        System.out.println(result);
        System.out.println(result.get(1));

    }
}
