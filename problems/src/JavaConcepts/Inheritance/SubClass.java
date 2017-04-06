package JavaConcepts.Inheritance;

/**
 * Created by raghu on 1/2/2017.
 */

class A
{
    int i = 10;
}

class B extends A
{
    int i = 20;
}



public class SubClass extends SuperClass {
    public static void main(String[] args) {

        SubClass sb = new SubClass();
        SuperClass sc = new SubClass();

        sb.subClassMethod();

        A a = new B();

        System.out.println(a.i);

    }

    public void subClassMethod()
    {
        System.out.println("Accessible");
        super.publicMethod();
    }

    @Override
    public void publicMethod() {
        System.out.println("SubMethod");
    }
}
