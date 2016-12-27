package com.neu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by raghu on 12/26/2016.
 */
public class StringDelettion {
    public static void main(String[] args) {
        Set<String> dic = new HashSet<String>();
        dic.add("v");
        dic.add("e");
        dic.add("n");
        dic.add("d");
        dic.add("r");
        dic.add("ver");
        dic.add("ven");
        dic.add("vedrn");
        dic.add("vendr");
        dic.add("ndr");
       // dic.add("Raghavend");
        System.out.println(new StringDelettion().stringdeletionV2("Raghavendra",dic));

    }

    public int stringdeletion(String str, Set<String> dic)
    {
        String maxString = "";


        for(String i : dic)
        {
            if(str.contains(i) && maxString.length() < i.length())
            {
                maxString = i;
            }
        }
        return (maxString.length()==0?0:str.length() - maxString.length());
    }

    public int stringdeletionV2(String query, Set<String> dic) {
        Queue<String> q = new LinkedList<String>();
        Set<String> s = new HashSet<String>();

        q.add(query);
        s.add(query);

        while (!q.isEmpty()) {
            String a = q.remove();
            s.remove(a);

            if (dic.contains(a)) return (query.length() - a.length());


            for (int i = 0; i < a.length(); i++) {
                String b = a.substring(0, i) + a.substring(i + 1, a.length());
                if (!s.contains(b)) {
                    q.add(b);
                    s.add(b);
                }
            }

        }
        return -1;
    }



}
