package com.neu.bBy;

/**
 * Created by raghu on 12/28/2016.
 */
public class MatrixSearch29 {
    public static void main(String[] args) {

        int a[][] = new int[3][];

        a[0] = new int[]{0,1,2};
        a[1] = new int[]{3,4,5};
        a[2] = new int[]{6,7,8};

        System.out.println(new MatrixSearch29().matrixSearch(a,4));

    }

    public Boolean matrixSearch(int [][] a, int x)
    {
        if(a.length == 0 || a[0].length ==0)
        {
            return false;
        }

        int row = 0;
        int col = a.length -1;

        while (row <= a[0].length-1 && col >=0)
        {
            System.out.println(a[row][col]);
            if(a[row][col] == x) return true;
            if(x < a[row][col]) col --;
            else
                row++;
        }
        return false;
    }
}
