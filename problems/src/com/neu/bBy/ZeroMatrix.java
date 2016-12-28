package com.neu.bBy;

/**
 * Created by raghu on 12/26/2016.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        Boolean[][] a = new Boolean[3][3];

        for(int i = 0; i < a.length; i++)
        {
            for(int j =0; j< a[0].length;j++)
            {
                a[i][j] = false;
            }
        }

        //a[1][2] = true;
        a[0][0] = true;

        for(int i = 0; i < a.length; i++)
        {
            for(int j =0; j< a[0].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        new ZeroMatrix().zeroMatrix(a);
        System.out.println("-----------------");
        System.out.println();

        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void zeroMatrix(Boolean[][] a)
    {
        //arrays has no rows or column
        if(a.length == 0 || a[0].length == 0)
            return;

        Boolean row=false;
        Boolean col=false;

        for(Boolean i: a[0])
        {
            row |= i;
        }

        for(Boolean b[]: a)
        {
            col |= b[0];
        }

        for(int i = 1; i < a.length; i++)
        {
            for(int j =1; j< a[0].length;j++)
            {
                if(a[i][j] == true)
                {
                    a[0][j] = true;
                    a[i][0] = true;
                }
            }
        }

        for(int i = 1; i < a.length; i++)
        {
            for(int j =1; j< a[0].length;j++)
            {
                if( a[0][j] == true || a[i][0] == true)
                {
                    a[i][j] = true;
                }
            }
        }

        if(row)
        {
            for(int i = 0 ; i <a[0].length ; i++)
            {
                a[0][i] = true;
            }
        }

        if(col)
        {
            for(int i = 0 ; i <a.length ; i++)
            {
                a[i][0] = true;
            }
        }

    }
}
