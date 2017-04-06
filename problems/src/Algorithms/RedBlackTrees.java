package Algorithms;

/**
 * Created by raghu on 3/20/2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RedBlackTrees {


    public static void main(String[] args) {
        RedBlackTree rb = new RedBlackTree();

     /*   rb.insert(rb.new Node(14));
        rb.insert(rb.new Node(11));
        rb.insert(rb.new Node(2));
        rb.insert(rb.new Node(1));
        rb.insert(rb.new Node(7));



       System.out.println(rb.sort());
       System.out.println("Balanaced: "+rb.checkBalance(rb.getRoot()));

        rb.insert(rb.new Node(5));
        rb.insert(rb.new Node(8));
        rb.insert(rb.new Node(4));

        System.out.println(rb.sort());
        System.out.println("Balanaced: "+rb.checkBalance(rb.getRoot()));

        rb.insert(rb.new Node(15));
        System.out.println(rb.sort());
        System.out.println("Balanaced: "+rb.checkBalance(rb.getRoot()));

        System.out.println("Minimum:" +rb.treeMinimum(rb.getRoot()).key);

        System.out.println("Maximum:"+rb.treeMaximum(rb.getRoot()).key);

        System.out.println("successor:"+ rb.successor(rb.search(7, rb.getRoot())).key);
        System.out.println("predecessor:"+ rb.predecessor(rb.search(7, rb.getRoot())).key);*/

        String line = null;
        try {
            FileReader fileReader =  new FileReader(args[0]);

            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                int num = Integer.parseInt(line);
                rb.insert(rb.new Node(num));
            }

            // Always close files.
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        while (true){
            System.out.println("1. Insert");
            System.out.println("2. search");
            System.out.println("3. Min");
            System.out.println("4. Max");
            System.out.println("5. Successor");
            System.out.println("6. Predecessor");
            System.out.println("7. Sort");
            System.out.println("8. checkBalanced");
            Scanner sc = new Scanner(System.in);
            int exp =  sc.nextInt();
            switch (exp){
                case 1:
                    System.out.println("Input a number to be inserted:");
                    int num  =  sc.nextInt();
                    rb.insert(rb.new Node(num));
                    System.out.println("Number Inserted");
                    break;
                case 2:
                    System.out.println("Input a number to be searched:");
                    int numSearch  =  sc.nextInt();
                     if(rb.search(numSearch, rb.getRoot()) == null){
                         System.out.println("Node not present");
                     }
                     else {
                         System.out.println("Node present");
                     }
                    break;
                case 3:
                    System.out.println("Minimum:" +rb.treeMinimum(rb.getRoot()).key);
                    break;
                case 4:
                    System.out.println("Maximum:"+rb.treeMaximum(rb.getRoot()).key);
                    break;
                case 5:
                    System.out.println("Input a number whose successor to be searched:");
                    int succ  =  sc.nextInt();
                    System.out.println("successor:"+ rb.successor(rb.search(succ, rb.getRoot())).key);
                    break;
                case 6:
                    System.out.println("Input a number whose predecessor to be searched:");
                    int pred  =  sc.nextInt();
                    System.out.println("predecessor:"+ rb.predecessor(rb.search(pred, rb.getRoot())).key);
                    break;
                case 7:
                    System.out.println(rb.sort());
                    break;
                case 8:
                    System.out.println("Balanaced: "+rb.checkBalance(rb.getRoot()));
                    break;
                default:System.exit(0);
            }


        }

    }
}

class RedBlackTree{
    private final int RED = 0;
    private final int BLACK = 1;

    class Node {

        int key = -1, color = BLACK;
        Node left = nil, right = nil, parent = nil;

        Node(int key) {
            this.key = key;
        }
    }

    public Node getNode(int key){
        return new Node(key);
    }

    ArrayList<Integer> sort(){
        ArrayList<Integer> sorted = new ArrayList<>();
        return  inorderTraversal(sorted, root);
    }

    private ArrayList<Integer> inorderTraversal( ArrayList<Integer> sorted, Node cur){
        if(cur != null) {
            inorderTraversal(sorted, cur.left);
            if(cur != nil)
                sorted.add(cur.key);
            inorderTraversal(sorted, cur.right);
        }
        return sorted;
    }

    private final Node nil = new Node(-1);
    private Node root = nil;

    public Node getRoot(){
        return root;
    }
    Node predecessor(Node x){
        if(x.left != nil){
            return treeMaximum(x.left);
        }
        Node y = x.parent;
        while (y != nil && x == y.left){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public Node search(int key, Node node) {
        if (root == nil) {
            return null;
        }

        if (key < node.key) {
            if (node.left != nil) {
                return search(key, node.left);
            }
        } else if (key > node.key) {
            if (node.right != nil) {
                return search(key, node.right);
            }
        } else if (key == node.key) {
            return node;
        }
        return null;
    }

    public void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }


    private void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if(y.left != nil)
        {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == nil){
            root = y;
        }
        else if(x == x.parent.left){
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y){
        Node x = y.left;
        y.left = x.right;

        if(x.right != nil)
            x.right.parent = y;

        x.parent = y.parent;

        if(y.parent == nil)
            root = x;
        else if(y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    Node treeMinimum(Node subTreeRoot){
        while(subTreeRoot.left!=nil){
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }

    Node treeMaximum(Node subTreeRoot){
        while(subTreeRoot.right!=nil){
            subTreeRoot = subTreeRoot.right;
        }
        return subTreeRoot;
    }

    Node successor(Node x){
        if(x.right != nil){
            return treeMinimum(x.right);
        }
        Node y = x.parent;
        while(y != nil  && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }

    public boolean checkBalance(Node root){
        int result = isBalanced(root);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    private int isBalanced(Node root){
        if(root == nil){
            return 0;
        }
        int leftH = isBalanced(root.left);
        if(leftH==-1){
            return -1;
        }
        int rightH = isBalanced(root.right);
        if(rightH==-1){
            return -1;
        }
        int diff = leftH-rightH;
        if(Math.abs(diff)>1){
            return -1;
        }
        return 1 + Math.max(leftH, rightH);
    }
}