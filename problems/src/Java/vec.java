package Java;

import org.omg.SendingContext.RunTime;
import org.omg.SendingContext.RunTimeOperations;

import java.util.Vector;
import static java.lang.Math.*;
/**
 * Created by raghu on 2/16/2017.
 */


public class vec{
    public final static void main(String[] args) throws NullPointerException {
        Vector<Integer> v = new Vector<>();
       // System.out.println(vec.b);
        System.out.println(sqrt(2));
        System.out.println(Math.sqrt(2));
        vec.helloStatic.diaplay();
    }

 /*   interface a {
        int a  = 0;
    }

    public void hello(){

    }

    public class b{

    }

   static int b;
    static public void a(){
        int a ;
        System.out.println(b);
    }*/
    public static double sqrt(double a){
        System.out.println("called");
        return 0;
    }

    private class hello{


    }

    static private String s = "Inside static class";

    static class helloStatic{
        static public void diaplay(){
            System.out.println(s);
        }
    }

    void innerMethod(){
        int a = 0;
        class MethodInner {
            public void dislay(){
                System.out.println(a);
            }
        }
    }

 int a ;

    static void hello(){
        System.out.println("Hello World");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Started");
            }
        };

        Thread t = new Thread(r);
        t.start();
        t.setDaemon(true);
        Runtime d = Runtime.getRuntime();
    }

    static {
        System.out.println("hello");
        new vec().hello();
    }

}
