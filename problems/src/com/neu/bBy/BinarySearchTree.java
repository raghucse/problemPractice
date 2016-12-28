package com.neu.bBy;

/**
 * Created by raghu on 12/18/2016.
 */


public class BinarySearchTree {
    static class Node{
        private int data;
        private Node right;
        private Node left;
    }

    public static void main(String[] args) {
        Node n5 = new Node();
        n5.data = 5;

        Node n2 = new Node();
        n2.data = 2;

        Node n3 = new Node();
        n3.data = 3;

        Node n1 = new Node();
        n1.data = 1;

        n5.left = n2;
        n2.left = n1;
        n3.right = n3;

        Node n7 = new Node();
        n7.data = 7;

        Node n8 = new Node();
        n8.data = 8;

        Node n6 = new Node();
        n6.data = 6;

        n5.right = n7;
        n7.left = n6;
        n7.right = n8;

        System.out.println(new BinarySearchTree().binarySearchTree(n5, Integer.MIN_VALUE,Integer.MAX_VALUE));


    }

    public Boolean binarySearchTree(Node n, int min, int max)
    {
        // if the leaf node reached or
        if(n == null) return true;

        if(n.data < min || n.data > max) return false;

        return binarySearchTree(n.left, min, n.data) && binarySearchTree(n.right, n.data, max);

    }

}
