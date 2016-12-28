package com.neu.bBy;

/**
 * Created by raghu on 12/21/2016.
 */
public class NStack {
    int[] stackData;
    int[] nextIndex;
    int[] topOfStack;
    int nexAvailableindex;

    public static void main(String[] args) {
        NStack n = new NStack(3, 6);
     //   n.printStack(n.stackData);

        n.push(0,3);
        n.push(1,4);
        n.pop(0);
        n.push(1,5);
        n.push(2,9);

        n.printStack(n.stackData);



    }


    NStack(int N, int capacity)
    {
        topOfStack = new int[N];
        for (int i = 0; i < topOfStack.length; i++) {
            topOfStack[i] = -1;
        }

        stackData = new int[capacity];
        nextIndex = new int[capacity];

        for(int i=0; i< stackData.length; i++)
        {
            stackData[i] =0;
        }

        for(int i=0; i< nextIndex.length-1; i++)
        {
            nextIndex[i] =i+1;
        }
        printStack(nextIndex);
        //to mark end of stack usuage
        nextIndex[nextIndex.length-1] = -1;
        nexAvailableindex = 0;
    }

    public void push(int stack, int item)
    {
        if(stack < 0 || stack > topOfStack.length)
        {
            return;
        }

        if(nexAvailableindex < 0)
        {
            return;
        }

        int currentIndex = nexAvailableindex;
        nexAvailableindex = nextIndex[currentIndex];
        nextIndex[currentIndex] = topOfStack[stack];
        topOfStack[stack] = currentIndex;
        stackData[currentIndex] = item;

    }

    public int pop(int stack)
    {
        if(stack < 0 || stack > topOfStack.length || topOfStack[stack] < -1)
        {
            return -1;
        }

        int currentIndex = topOfStack[stack];
        int value = stackData[currentIndex];
        topOfStack[stack] = nextIndex[currentIndex];
        nextIndex[currentIndex] = nexAvailableindex;
        nexAvailableindex = currentIndex;
        return value;
    }

    public void printStack(int[] a)
    {
        for(int i : a)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
    }

}
