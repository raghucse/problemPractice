package com.neu.Algos;

/**
 * Created by raghu on 2/16/2017.
 */
public class Outer
{
    public void someOuterMethod()
    {
        //Line 5
    }
    public class Inner { }

    interface a{

    }

    interface b{

    }
    interface c extends a, b{

    }

    class d implements b, a{

    }



    public static void main(String[] argv)
    {
        Outer ot = new Outer();
        ot.new Inner();

    }
}
