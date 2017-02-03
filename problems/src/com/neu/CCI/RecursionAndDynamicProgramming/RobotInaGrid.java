package com.neu.CCI.RecursionAndDynamicProgramming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by raghu on 1/6/2017.
 */
class Point{
        int x;
        int y;

        Integer a = new Integer(2);

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
}


public class RobotInaGrid {
    public static void main(String[] args) {
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<>();
        boolean maze[][] = new boolean[4][4];

        Stack<Integer> s = new Stack<Integer>();

    }

    public boolean robotInaGrid(boolean maze[][], int r,int c,ArrayList<Point> path, HashSet<Point> failedPoints)
    {
        if(c < 0 || r < 0 || !maze[r][c])
        {
            return false;
        }

        Boolean atOrigin = ( r == 0 && c==0);

        Point p = new Point(r,c);
        if(!failedPoints.contains(p))
            return false;


        if(atOrigin || robotInaGrid(maze, r-1, c, path, failedPoints) || robotInaGrid(maze, r, c-1, path, failedPoints))
        {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

}

