package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 */
public class Insertion {
    public static void main(String[] args) {
        int n = 0b10000000;
        int m = 0b10011;
        int j = 6;


//        System.out.println(n);
//        System.out.println(Integer.toBinaryString(n));
        new Insertion().Insertion(n, m, 2, 6);

    }

    public void Insertion(int n, int m, int i, int j)
    {
        int allOnes  = ~0 << (j+1);
     //   System.out.println(Integer.toBinaryString(allOnes));

        int right = ((1 << i)-1); // -1 to make all bits one again.. Example : its 16 1000 will make it 15 if all are one
      //  System.out.println(right);
      //  System.out.println(Integer.toBinaryString(right));

        int mask = allOnes | right;
       System.out.println(Integer.toBinaryString(mask));


        int clear = n & mask;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(clear));
        int insertNum = m << i;

        System.out.println("iN: "+Integer.toBinaryString(insertNum));
        int operate = clear | insertNum;

       System.out.println(Integer.toBinaryString(operate));

    }
}
