package com.neu.Algos;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by raghu on 2/12/2017.
 */
public class longestSubsequence {
    public static void main(String[] args) {
        int a[] = {-2,4,120,5,6,121,122,123,124,9};

    }

    public ArrayList<Integer> longestSubSequence(int a[]){
        ArrayList<ArrayList> longestSequence =  new ArrayList<>();

        for(int i = a.length-1 ; i >= 0 ;i-- ){
            if(i == a.length - 1){
                ArrayList<Integer> list =  new ArrayList<>();
                list.add(a[i]);
                longestSequence.add(list);
            }
            else {
                ArrayList<Integer> currentLongest = new ArrayList<>();
                currentLongest.add(a[i]);
                for(int j= i+1; j < a.length; j++){
                    if(a[j] > a[i]) {
                        int index = (a.length - 1) - j;
                        ArrayList<Integer> longestIn = longestSequence.get(index);
                        if (longestIn.size() > (currentLongest.size() - 1)) {
                            currentLongest = new ArrayList<>();
                            currentLongest.add(a[i]);
                            currentLongest.addAll(longestIn);
                        }
                    }
                }
                longestSequence.add(currentLongest);
            }
        }

        ArrayList<Integer> longest = longestSequence.get(0);
        for(ArrayList<Integer> ad : longestSequence){
            if(longest.size() < ad.size()){
                longest = ad;
            }
        }

        return longest;
    }


}

