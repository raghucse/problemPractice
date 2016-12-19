package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by raghu on 12/17/2016.
 */
public class LonelyElement {

    private static int lonelyInteger2(int[] a) {
        List<Integer> al = new ArrayList<Integer>();
        for(int i=0; i < a.length; i++)
        {
            if(al.contains(a[i]))
            {
                al.remove(new Integer(a[i]));

            }
            else
            {
                al.add(a[i]);
            }
        }
        return al.get(0);
    }

    private static int lonelyInteger(int[] a) {
        List<Integer> al = new ArrayList<Integer>();
        for(int i=0; i < a.length; i++)
        {
            if(al.contains(a[i]))
            {
                al.remove(new Integer(a[i]));

            }
            else
            {
                al.add(a[i]);
            }
        }
        return al.get(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}
