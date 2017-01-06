package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 * Next Number: Given a positive integer, print the next smallest and the next largest number that
 have the same number of 1 bits in their binary representation.
 */
public class GetNextNumber {
    public static void main(String[] args) {
    	int n1 = 3;
    	int n2 = 5;
    	int n3 = 7;

    	GetNextNumber gn = new GetNextNumber();
    	System.out.println(gn.getnextNumber(3));
    	System.out.println(gn.getnextNumber(5));
    	System.out.println(gn.getnextNumber(7));
    }

    public int getnextNumber(int n)
    {

    	int p = 0; // right most non trailing zero
    	int c1 = 0; // number of one to right of p
    	int c0 = 0; // number of zero to right of p
    	int c = n; // stored in temp for determining c1 and c0

    	while((c & 1) == 0 && c != 0)
    	{
    		c0++;
    		c >>= 1;
    	}

    	while((c & 1) == 1 && c != 0)
    	{
    		c1++;
    		c >>= 1;
    	}

    	p = c0 + c1;

    	//---------bit manupulation of n starts-------------

    	//flip the right most non trailing zero

    	n |= ( 1 << p);

    	//mask the bit to the right of p
    	n &= ~((1 << p) - 1);

    	n |=  (1 << (c1-1))-1;

    	return n;
    }

}
