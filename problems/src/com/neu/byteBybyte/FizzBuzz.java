package com.neu.byteBybyte;

/**
 * Created by raghu on 12/18/2016.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        new FizzBuzz().fizzBuzz(15);
    }

    public void fizzBuzz(int highLimit)
    {

        for(int i=1; i<= highLimit; i++)
        {
            if(i%3 == 0 && i%5 ==0)
                System.out.println("FizzBuzz");
            else if(i%3 == 0)
                System.out.println("Fizz");
            else if(i%5 == 0)
                System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
