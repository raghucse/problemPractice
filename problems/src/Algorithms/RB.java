package Algorithms;

import java.util.ArrayList;

/**
 * Created by raghu on 3/18/2017.
 */
public class RB {
    public static void main(String[] args) {
        RBS rb = new RBS();

        rb.insert(new Node(14));
        rb.insert(new Node(11));
        rb.insert(new Node(2));
        rb.insert(new Node(1));
        rb.insert(new Node(7));

        System.out.println(rb.sort());
        System.out.println(rb.checkBalance(rb.root));

        rb.insert(new Node(5));
        rb.insert(new Node(8));
        rb.insert(new Node(4));

        System.out.println(rb.sort());
        System.out.println(rb.checkBalance(rb.root));

        rb.insert(new Node(15));
        System.out.println(rb.sort());
        System.out.println(rb.checkBalance(rb.root));

        System.out.println("Minimum:" +rb.min(rb.root).key);

        System.out.println("Maximum:"+rb.max(rb.root).key);

        System.out.println(rb.root.left.key);
    }
}


class Node{
    int key;
    String color; // color can be red or black
    Node parent;
    Node left;
    Node right;
    Boolean isNil;
    Node(int key){
        this.key = key;
        color = "Red";
        isNil = false;
    }
}

class RBS{
    Node root;

    void insert(Node z){
        Node y = new Node(-1);
        y.isNil = true;
        y.color = "Black";
        Node x = root;

     if(x == null){
            root = z;
            z.color = "Black";
            z.parent = y;
         z.left = new Node(-1);
         z.left.isNil =  true;
         z.left.color = "Black";
         z.right = new Node(-1);
         z.right.isNil =  true;
         z.right.color = "Black";
            return;
        }

        while (!x.isNil){
            y = x;
            if(z.key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;

        if(y.isNil)
            root = z;
        else if(z.key < y.key){
            y.left = z;
        }
        else
            y.right = z;

        z.left = new Node(-1);
        z.left.isNil =  true;
        z.left.color = "Black";
        z.right = new Node(-1);
        z.right.isNil =  true;
        z.right.color = "Black";
        z.color = "Red";
       /* z.parent = new Node(-1);
        z.parent.isNil =  true;
        z.parent.color = "Black";*/
        System.out.println(z.key);
        if(!z.parent.isNil || !z.parent.parent.isNil)
            insertFixUP(z);
        else
            z.color = "Black";
    }

    private void insertFixUP(Node z){
        while (z.color == "Red"){
            if(z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if(y.color == "Red"){
                    z.parent.color = "Black";
                    y.color = "Black";
                    z.parent.parent.color = "Red";
                    z = z.parent.parent;
                }
                else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = "Black";
                    z.parent.parent.color = "Red";
                    rightRotate(z.parent.parent);
                }
            }
            else if(z.parent == z.parent.parent.right){
                Node y = z.parent.parent.left;
                if(y.color == "Red"){
                    z.parent.color = "Black";
                    y.color = "Black";
                    z.parent.parent.color = "Red";
                    z = z.parent.parent;
                }
                else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = "Black";
                    z.parent.parent.color = "Red";
                    leftRotate(z.parent.parent);
                }
            }

        }
    }

    Node Successor(Node x){
        if(x.right != null){
            return min(x.right);
        }
        Node y = x.parent;
        while(y != null  && x == y.right){
            x = y;
            y = y.parent;
        }
        return y;
    }

    Node getRoot(){
        return root;
    }


    Node predecessor(Node x){
        if(x.left != null){
            return max(x.left);
        }
        Node y = x.parent;
        while (y != null && x == y.left){
            x = y;
            y = y.parent;
        }
        return y;
    }

    Node min(Node x){
        while (!x.left.isNil){
            x = x.left;
        }
        return x;
    }

    Node max(Node x){
        while (!x.right.isNil){
            x = x.right;
        }
        return x;
    }

    ArrayList<Integer> sort(){
        ArrayList<Integer> sorted = new ArrayList<>();
        return  inorderTraversal(sorted, root);
    }

    private ArrayList<Integer> inorderTraversal( ArrayList<Integer> sorted, Node cur){
        if(cur != null) {
            inorderTraversal(sorted, cur.left);
            if(!cur.isNil)
              sorted.add(cur.key);
            inorderTraversal(sorted, cur.right);
        }
        return sorted;
    }

    Node search(int key){
        Node x = root;
        while (x != null){
            if(x.key == key)
                return x;
            if(x.key < key )
                x = x.left;
            else
                x = x.right;
        }
        return null;
    }

    private void leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;

        if(!y.left.isNil){
            y.left.parent = x;
        }

        y.parent = x.parent;

        if(!x.parent.isNil){
            root = y;
        }
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y){
        Node x = y.left;
        y.left = x.right;

        if(!x.right.isNil)
            x.right.parent = y;

        x.parent = y.parent;

        if(!y.parent.isNil)
            root = x;
        else if(y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
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
        if(root.isNil){
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

  /*  public void printTree(Node node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(((node.color==RED)?"Color: Red ":"Color: Black ")+"Key: "+node.key+" Parent: "+node.parent.key+"\n");
        printTree(node.right);
    }*/

}