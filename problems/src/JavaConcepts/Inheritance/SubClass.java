package JavaConcepts.Inheritance;

/**
 * Created by raghu on 1/2/2017.
 */
public class SubClass extends SuperClass {
    public static void main(String[] args) {

        SubClass sb = new SubClass();
        SuperClass sc = new SubClass();

        sb.subClassMethod();

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
