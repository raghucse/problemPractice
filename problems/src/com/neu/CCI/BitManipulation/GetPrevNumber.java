package com.neu.CCI.BitManipulation;

/**
 * Created by raghu on 1/3/2017.
 */
public class GetPrevNumber {
	public static void main(String args[])
	{
        int n1 = 3;
        int n2 = 5;
        int n3 = 7;

        GetPrevNumber gn = new GetPrevNumber();
        System.out.println(gn.getPrevNumber(5));
        System.out.println(gn.getPrevNumber(6));
        System.out.println(gn.getPrevNumber(11));
	}

	public int getPrevNumber(int n)
	{
		int p = 0; //right most non trailing one
		int c1 = 0 ; // number of one's to right of p
		int c0 = 0; // number of zero's to right of p
		int c = n;

		while((c & 1) == 1)
		{
			c1++;
			c >>=1;
		}

		if(c == 0) return -1;

		while((c & 1) == 0)
		{
			c0++;
			c >>=1;
		}

		p =  c1+ c0;

		n &= (~0 << (p+1));

		int mask = (1 << (c1+1))-1;
		mask <<= c0-1; 

		n |= mask;

		return n;
	}
}
