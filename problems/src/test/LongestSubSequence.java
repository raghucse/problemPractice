package test;

import java.util.Arrays;

/**
 * Created by raghu on 1/14/2017.
 */
public class LongestSubSequence {
    public static void main(String[] args) {

        int grid[][] = {{8,2,4}, {0,6,1}, {3,7,9}};
        int grid2[][] = {{4,2,4}, {0,3,1}, {3,7,9}};

        System.out.println(new LongestSubSequence().longestSequence(grid2));
    }

    public int longestSequence(int grid[][])
    {
        int result = 1;
        int dp[][] = new int[grid.length][grid[0].length];
        Boolean visited[][] = new Boolean[grid.length][grid[0].length];
        //Arrays.fill(dp, -1);

        for(int i=0 ; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        for(int i=0 ; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }

        for(int i=0 ; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length;j++)
            {
                 ;

                result =  Math.max(result, findLongestFromACell(i,j, grid, dp, visited));
            }
        }
        return result;
    }

    public int findLongestFromACell(int i, int j, int grid[][], int dp[][], Boolean visited[][])
    {


        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length )
        {
            return 0;
        }

        if(visited[i][j])
            return 0;


        int max = 1;
        // Since all numbers are unique and in range from 1 to n*n,
        // there is atmost one possible direction from any cell
        if ( (j<grid[0].length-1) && (Math.abs(grid[i][j] - grid[i][j+1]) > 3)){
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i,j+1,grid,dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;
        }


        if ( (j>0) && (Math.abs(grid[i][j] - grid[i][j-1]) > 3)) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i, j - 1, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;

        }

        if ( (i>0) && (Math.abs(grid[i][j] - grid[i-1][j]) > 3)) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i - 1, j, grid, dp,visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;
        }

        if ( (i<grid.length-1) && (Math.abs(grid[i][j] - grid[i+1][j]) > 3)) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i + 1, j, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;

        }

        if ((i >0 && j >0) && Math.abs(grid[i][j] - grid[i-1][j-1]) > 3) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i - 1, j - 1, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;

        }

        if ((i<grid.length-1 && j > 0) && Math.abs(grid[i][j] - grid[i+1][j-1]) > 3) {
            visited[i][j] = true;
           dp[i][j] = 1 + findLongestFromACell(i + 1, j - 1, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;

        }

        if ((i<grid.length-1 && j<grid[0].length-1) && Math.abs(grid[i][j] -  grid[i+1][j+1]) > 3) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i + 1, j + 1, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;

        }

        if ((i > 0 && j < grid[0].length-1) && Math.abs(grid[i][j] - grid[i-1][j+1]) > 3) {
            visited[i][j] = true;
            dp[i][j] = 1 + findLongestFromACell(i - 1, j + 1, grid, dp, visited);
            max = Math.max(max, dp[i][j]);
            dp[i][j] = max;
            visited[i][j] = false;
        }



        // If none of the adjacent fours is one greater

      //  dp[i][j] = 1;
        return max;
    }
}
