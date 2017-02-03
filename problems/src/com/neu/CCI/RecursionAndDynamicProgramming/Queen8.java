package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.ArrayList;

/**
 * Created by raghu on 1/11/2017.
 */
public class Queen8 {
    int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> result = new ArrayList<>();



    }

    public void getPossiblePlaces(Integer[] column, int row, ArrayList<Integer[]> result)
    {
        if(row == GRID_SIZE)
        {
            result.add(column.clone());
        }
        else {

            for (int col = 0; col < GRID_SIZE; col++) {
                if (check(column, col, row)) {
                    column[row] = col;
                    getPossiblePlaces(column, row + 1, result);
                }
            }
        }
    }

    public Boolean check(Integer column[], int col1, int row1)
    {
        for(int row2 = 0; row2 < row1; row2++)
        {
            int col2  = column[row2];

                if(col1 == col2)
                return false;


            //checking if diagonal equal
            int colDist = Math.abs(col1-col2);

            int rowDist =  row1 - row2;

            if(rowDist == colDist)
            {
                return false;
            }


        }

        return true;

    }


}
