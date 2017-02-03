package com.neu.CCI.ArraysAndString;

/**
 * Created by raghu on 1/12/2017.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(new PalindromePermutation().palindromePermutation("malaylaam"));
        System.out.println(new PalindromePermutation().isPermutationOfPalindrome("raghu"));
    }

    public Boolean palindromePermutation(String s)
    {
        int count = 0;
        int oddCounter = 0;
        for(int i =0; i< s.length(); i++)
        {
            int num = s.charAt(i) - 'a';
            //System.out.println(num);
            int mask = 1 << num;
            oddCounter ^= mask;
            //System.out.println(oddCounter);
        }



        while (oddCounter != 0)
        {
            if(oddCounter % 2 ==1 )
                    count++;
            oddCounter >>= 1;
        }

        if(count > 2)
        {
            return false;
        }
        else
            return true;

    }

     boolean isPermutationOfPalindrome(String phrase) {
         int bitVector = createBitVector(phrase);
         return bitVector == 0 || checkExactlyOneBitSet(bitVector);
        }


    int createBitVector(String phrase) {
         int bitVector = 0;
         for (char c : phrase.toCharArray()) {
             int x = 'c';
             bitVector= toggle(bitVector, x);
            }
         return bitVector;
         }

    /* Toggle the ith bit in the integer. */
    int toggle(int bitVector, int index) {
         if (index < 0) return bitVector;
         int mask= 1 << index;
         if ((bitVector & mask)==0){
                bitVector |= mask;
         } else {
               bitVector &= ~mask;
    }
         return bitVector;
    }

     /* Check that exactly one bit is set by subtracting one from the integer and
        * ANDing it with the original integer. */
             boolean checkExactlyOneBitSet(int bitVector) {
         return (bitVector & (bitVector - 1)) == 0;
         }
}
