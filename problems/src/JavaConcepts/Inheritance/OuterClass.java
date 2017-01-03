package JavaConcepts.Inheritance;

/**
 * Created by raghu on 1/2/2017.
 */
public class OuterClass {
    private int a  =0 ;
    public int b = 0;

    class InnerClass{
        int c =0;

        public void innerMethos()
        {
            System.out.println(a);
        }

    }

    public void outerMethod()
    {
        System.out.println(a);
    }
}
