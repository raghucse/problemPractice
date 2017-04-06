package Algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by raghu on 3/17/2017.
 */

public class Hashing{
    public static void main(String[] args) {
        Hash h = new Hash(701);
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String keys[] = sCurrentLine.split(" ");

                for (String key: keys) {
                    if (h.find(key) != -1) {
                        h.increase(key);
                    }
                    else
                    {
                        h.insert(key, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        h.listAllKeys();
    }
}

class Hash {
    int m;
    LinkedList[] bins;

    Hash(int m){
        this.m = m;
        bins = new LinkedList[m];
    }


    int generateHash(String key){
        double hash = 7;
        for (int i = 0; i < key.length(); i++) {
            hash = hash*31 + key.charAt(i);
        }
        return (int)(hash%m);
    }

    void insert(String key, int value){
        int hash = generateHash(key);
        hash = hash % m;

        if(bins[hash] == null){
            LinkedList l = new LinkedList(key,value);
            bins[hash]  = l;
        }
        else
            bins[hash].insert(key, value);

    }

    void delete(String key){
        int hash = generateHash(key);
        hash = hash % m;
        bins[hash].delete(key);
    }

    int find(String key){
        int hash = generateHash(key);

        if(bins[hash] != null)
            return bins[hash].getValue(key);
        return -1;
    }

    void increase(String key){
        int hash = generateHash(key);
        hash = hash % m;
        bins[hash].increaseKey(key);
    }

    void listAllKeys(){
        for(int i = 0 ; i < bins.length ; i++){
            if(bins[i] != null)
                bins[i].printKeys();
        }
    }
}


class LinkedList{
    class Node{
        String key;
        int value;
        Node prev;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    LinkedList(String key, int value){
        head = new Node(key,value);
    }

    void insert(String key, int value){
        Node n = new Node(key, value);
        if(head == null){
            head = n;
        }
        else{
            n.next = head;
            head = n;
        }
    }

    void delete(String key){
        Node temp = head;
        while(temp != null)
        {
            if(temp.key.equals(key)){
                if(temp.prev == null){
                    head = temp.next;
                }
                else {
                    temp.prev.next =  temp.next;
                }
            }
            temp = temp.next;
        }
    }

    int getValue(String key){
        Node temp = head;

        while(temp != null){
            if(temp.key.equals(key)){
               return temp.value;
            }
            temp = temp.next;
        }

        return -1;
    }

    void printKeys(){
        Node temp = head;

        while(temp != null){
           System.out.println("key: "+temp.key+" , value: "+temp.value);
            temp = temp.next;
        }
    }

    void increaseKey(String key){
        Node temp = head;

        while(temp != null){
            if(temp.key.equals(key)){
                temp.value = temp.value + 1;
                return;
            }
            temp = temp.next;
        }
    }

}

