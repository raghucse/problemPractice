package com.neu;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by raghu on 12/13/2016.
 */
public class StringCompression {
    public static void main(String[] args) {
        String m = "aabcccccaaa";
        String mArray[] = m.split("");
        Map<String, Integer> compressedMap = new LinkedHashMap();

        for (String s : mArray)
        {
            if(compressedMap.containsKey(s))
            {
                int count = compressedMap.get(s);
                compressedMap.put(s, ++count);
            }
            else
            {
                compressedMap.put(s, 1);
            }
        }
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String,Integer> e: compressedMap.entrySet() )
        {
            s.append(e.getKey()+""+e.getValue());
        }
        if(s.toString().length() > m.length())
        {
            System.out.println(m);
        }
        else {
            System.out.println(s.toString());
        }

    }
}
