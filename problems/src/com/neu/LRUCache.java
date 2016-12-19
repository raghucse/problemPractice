package com.neu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raghu on 12/13/2016.
 */
public class LRUCache {


        Map<Integer, Integer> cache = null;
        int capacity = 0;

        public LRUCache(int capacity) {
                this.capacity = capacity;
                cache = new LinkedHashMap<>(capacity);

                cache = new LinkedHashMap(capacity + 1, .75F, true) {

                        protected boolean removeEldestEntry(Map.Entry eldest) {
                                return size() > capacity;
                        }
                };
        }

        public int get(int key) {
                if(cache.containsKey(key))
                {
                        int value =  cache.get(key);
                        return value;
                }
                else
                        return -1;
        }

        public void set(int key, int value) {
                if(cache.containsKey(key))
                {
                        cache.remove(key);
                        cache.put(key,value);
                }
                else if(capacity != cache.size())
                {
                        cache.put(key,value);
                }
                else
                {
                        int  key2 = cache.keySet().iterator().next();
                        cache.remove(key2);
                        cache.put(key,value);
                        System.out.println(cache);
                }

        }

}