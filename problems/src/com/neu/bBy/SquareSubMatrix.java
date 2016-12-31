package com.neu.bBy;

/**
 * Created by raghu on 12/31/2016.
 */
public class SquareSubMatrix {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{1,1,1,0};
        a[1] = new int[]{1,1,1,1};
        a[2] = new int[]{1,1,1,0};

        new SquareSubMatrix().sqaureSubMat(a);

    }

    public void sqaureSubMat(int a[][])
    {
        int x = a.length;
        if(x == 0) return;
        int y = a[0].length;
        if(y == 0) return;

        int max = 0;
        int dynamo[][] = new int[x][y];


        for(int i =0 ; i < x ; i++)
        {
            for(int j=0; j < y; j++)
            {
                if(i == 0 || j==0 )
                    dynamo[i][j] = a[i][j];
                else if(a[i][j] == 1)
                {
                    dynamo[i][j] = Math.min(dynamo[i][j-1],Math.min(dynamo[i-1][j],dynamo[i-1][j-1])) +1;
                }
                if(dynamo[i][j] > max)
                {
                    max = dynamo[i][j];
                }
            }
        }

        System.out.println(max);
    }

}
