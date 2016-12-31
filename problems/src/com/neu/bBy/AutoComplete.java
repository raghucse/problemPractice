package com.neu.bBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raghu on 12/31/2016.
 */
public class AutoComplete {
    class Node{
        String prefix; //Stores Word so far
        Map<Character, Node> children;
        boolean isWord; //is it a complete word

        Node(String prefix)
        {
            this.prefix = prefix;
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        String[] dict= {"aaa", "aab", "aaab","daaaf","baaf"};

        AutoComplete  at = new AutoComplete(dict);
        System.out.println(at.getWordForPrefix("aaa"));
    }


    private Node trie;

    public AutoComplete(String[] dict)
    {
        trie = new Node(""); // Starting Initial root node
        for(String s: dict) insertWord(s);
    }

    private void insertWord(String s)
    {
        Node curr = trie;

        for(int i = 0; i< s.length(); i++)
        {
            if(!curr.children.containsKey(s.charAt(i)))
            {
                curr.children.put(s.charAt(i), new Node(s.substring(0,i+1)));
            }
            curr = curr.children.get(s.charAt(i));
            if(i == s.length()-1) curr.isWord = true;
        }

    }

    public List<String> getWordForPrefix(String pre)
    {
        List<String> results = new ArrayList<>();
        Node curr = trie;
        for(char c: pre.toCharArray())
        {
            if(curr.children.containsKey(c))
            {
                curr = curr.children.get(c);
            }
            else {
                return results;
            }
        }

        findAllChildWords(curr,results);
        return results;

    }

    private void findAllChildWords(Node n,List<String> results)
    {
        if(n.isWord) results.add(n.prefix);
        for(Character c: n.children.keySet())
        {
            findAllChildWords(n.children.get(c),results);
        }
    }
}
