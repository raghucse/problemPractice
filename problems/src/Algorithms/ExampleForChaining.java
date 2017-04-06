package Algorithms;

/**
 * Created by raghu on 3/23/2017.
 */
public class ExampleForChaining {
    public static void main(String[] args) {
        B a = new B();

    }
}

class A{
   int x;
   A(){
       System.out.println("A called");
       x =90;
   }
}

class B extends A{
    B(){
        System.out.println("B called");
        System.out.println(x);
    }



}

interface C{

}
interface d{

}

interface e extends d,C{

}