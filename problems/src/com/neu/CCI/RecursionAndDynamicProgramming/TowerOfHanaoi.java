package com.neu.CCI.RecursionAndDynamicProgramming;

import java.util.Stack;

/**
 * Created by raghu on 1/8/2017.
 * https://www.youtube.com/watch?v=rVPuzFYlfYE
 * https://www.java2novice.com/data-structures-in-java/stacks/towers-of-hanoi/
 */
public class TowerOfHanaoi {
    public static void main(String[] args) {
        Stack<Integer> origin= new Stack<>();
        Stack<Integer> buffer= new Stack<>();
        Stack<Integer> destination = new Stack<>();

        origin.push(4);
        origin.push(3);
        origin.push(2);
        origin.push(1);


        new TowerOfHanaoi().move(origin.size(), origin, buffer, destination);
        System.out.println(destination);

    }

    public void move(int n, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination)
    {
        if(n > 0) {
            move(n - 1, origin, destination, buffer);
            destination.push(origin.pop());
            move(n - 1, buffer, origin, destination);
        }
    }

}
