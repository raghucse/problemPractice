package Algorithms;


import java.util.*;
import java.io.*;
enum color {
    red,black;
}

class tnode
{
    int data;
    tnode left,right,parent;
    color co;
    tnode(int x)
    {
        data=x;
        co=color.red;
    }
}

class redblack
{
    tnode root;

    public void insert(int x)
    {
        tnode temp=new tnode(x);
        root=insert_util(root,temp);
        fix(temp,root);
    }

    public int height(tnode root){
        if (root==null)
            return 0;
        else
        {
            int lDepth = height(root.left);
            int rDepth = height(root.right);

       /* use the larger one */
            if (lDepth > rDepth)
                return(lDepth+1);
            else return(rDepth+1);
        }
    }

    public tnode insert_util(tnode root,tnode temp)
    {
        if(root==null)
        {
            return temp;
        }

        if(root.data<temp.data)
        {
            root.right=insert_util(root.right,temp);
            root.right.parent=root;
        }else if(root.data>temp.data)
        {
            root.left=insert_util(root.left,temp);
            root.left.parent=root;
        }
        return root;
    }

    public tnode search(tnode root, int key){
        if(root == null || root.data == key)
            return root;
        else if(root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public tnode min(tnode node){
        while(node.left != null)
            node = node.left;
        return node;
    }

    public tnode max(tnode node){
        while(node.right != null)
            node = node.right;
        return node;
    }

    public tnode successor(tnode root, int x){
        tnode node = search(root, x);
        if(node.right != null)
            return min(node.right);
        tnode y = node.parent;
        while( y != null && node == y.right){
            node = y;
            y = y.parent;
        }
        return y;
    }

    public tnode predeccessor(tnode root, int x){
        tnode node = search(root, x);
        if(node.left != null)
            return max(node.left);
        tnode y = node.parent;
        while( y != null && node == y.left){
            node = y;
            y = y.parent;
        }
        return y;
    }

    public void leftrotate(tnode root)
    {
        tnode nroot=root.right,pp=root.parent,temp=nroot.left;
        nroot.left=root;
        root.parent=nroot;
        root.right=temp;
        if(temp!=null)
            temp.parent=root;

        if(pp!=null)
        {
            nroot.parent=pp;
            if(pp.left==root)
                pp.left=nroot;
            else
                pp.right=nroot;
        }
        else{
            this.root=nroot;
        }
    }

    public void rightrotate(tnode root)
    {
        tnode nroot=root.left,temp=nroot.right,pp=root.parent;
        nroot.right=root;
        root.parent=nroot;
        root.left=temp;

        if(temp!=null){
            temp.parent=root;
        }

        if(pp!=null){
            nroot.parent=pp;
            if(pp.left==root){
                pp.left=nroot;
            }
            else
                pp.right=nroot;
        }
        else
            this.root=nroot;
    }

    public void fix(tnode temp,tnode root)
    {
        if(temp==root)
        {
            temp.co=color.black;
            return ;
        }
        tnode uncle, p=temp.parent;
        tnode gp=p.parent;
        color t;

        if(p.co==color.black)
        {
            return;
        }
        else{
            if(gp.left==p)
            {
                uncle=gp.right;
            }
            else {
                uncle=gp.left;
            }
            if(uncle!=null && uncle.co==color.red)
            {
                if(gp!=root){
                    gp.co=color.red;
                }
                p.co = color.black;
                uncle.co=color.black;
            }
            else{
                if(gp.left==p){
                    if(p.left==temp)
                    {
                        rightrotate(gp);
                        t=gp.co;
                        gp.co=p.co;
                        p.co=t;
                    }
                    else{
                        leftrotate(p);
                        rightrotate(gp);
                        t=gp.co;
                        gp.co=p.co;
                        temp.co=t;
                    }
                }
                else
                {
                    if(p.right==temp)
                    {
                        leftrotate(gp);
                        t=gp.co;
                        gp.co=p.co;
                        p.co=t;
                    }
                    else{
                        rightrotate(p);
                        leftrotate(gp);
                        t=gp.co;
                        gp.co=p.co;
                        temp.co=t;
                    }
                }
            }
        }
    }

    public void inorder(tnode root)
    {
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}

public class tree
{
    public static void main (String[] args) throws  IOException{
        redblack r = new redblack();

        File inFile = new File(args[0]);
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            stringBuffer.append(" ");
        }
        fileReader.close();
        int len = stringBuffer.toString().split(" ").length;
        int m = 0;
        while(m != len){
            String str = stringBuffer.toString().split(" ")[m];
            int b = Integer.parseInt(str);
            if(m == 0)
                r.insert(b);
            else
            {
                if(r.search(r.root, b) == null)
                    r.insert(b);
            }
            m++;
        }

        Scanner sc = new Scanner(System.in);
        int c = 1;

        do{
            System.out.println("Select one of the below operation :");
            System.out.println("1. Insert key");
            System.out.println("2. Search key");
            System.out.println("3. Sort keys");
            System.out.println("4. Minimum key");
            System.out.println("5. Maximum key");
            System.out.println("6. Successor key");
            System.out.println("7. Predecessor key");
            System.out.println("8. Quit");
            c = sc.nextInt();
            switch (c){
                case 1 :
                    System.out.println("Enter the number that you want to insert : ");
                    int i = sc.nextInt();
                    r.insert(i);
                    System.out.println("Key Successfully Inserted");
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 2 :
                    System.out.println("Enter the number that you want to insert : ");
                    int j = (int) sc.nextInt();
                    tnode node = r.search(r.root, j);
                    if(node != null){
                        System.out.println("Found key " + j + " in the Tree");
                    }else{
                        System.out.println("No such key present in the tree");
                    }
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 3:
                    System.out.println("keys after sorting");
                    r.inorder(r.root);
                    System.out.println();
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 4:
                    System.out.println("Minimum key value in the tree " + r.min(r.root).data);
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 5:
                    System.out.println("Maximum key value in the tree " + r.max(r.root).data);
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 6:
                    System.out.println("Enter the key to the find its successor ");
                    int k = sc.nextInt();
                    tnode n = r.search(r.root, k);
                    if(n != null){
                        tnode s = r.successor(r.root, k);
                        if(s != null)
                            System.out.println("Successor of " + k + " is " + s.data);
                        else
                            System.out.println("Successor doesn't exist for " + k);
                    }else{
                        System.out.println("No such key present in the tree");
                    }
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 7:
                    System.out.println("Enter the key to the find its predecessor ");
                    int l = sc.nextInt();
                    tnode n1 = r.search(r.root, l);
                    if(n1 != null){
                        tnode s1 = r.predeccessor(r.root, l);
                        if(s1 != null)
                            System.out.println("Predecessor of " + l + " is " + s1.data);
                        else
                            System.out.println("Predecessor doesn't exist for " + l);
                    }else{
                        System.out.println("No such key present in the tree");
                    }
                    System.out.println("Height of the tree is " + r.height(r.root));
                    break;

                case 8:
                    break;

                default:
                    System.out.println("Please select any of these : 1, 2, 3, 4, 5, 6, 7, 8");
            }
        } while(c != 8);
    }
}
