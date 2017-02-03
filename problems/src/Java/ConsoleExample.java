package Java;

import java.io.Console;
/**
 * Created by raghu on 1/7/2017.
 *Returns the unique Console object associated with the current Java virtual machine, if any.
 If there is no console associated to the javadoc, the pointed line is the call of a method on a null object, hence the exception.

 How do you launch your application ?

 Whether a virtual machine has a console is dependent upon the underlying platform and also upon the manner in which the virtual machine is invoked.
 If the virtual machine is started from an interactive command line without redirecting the standard input and output streams then its console will
 exist and will typically be connected to the keyboard and display from which the virtual machine was launched. If the virtual machine is
 started automatically, for example by a background job scheduler, then it will typically not have a console.
 */
public class ConsoleExample {
    public static void main(String[] args) {
        Console c=System.console();
        System.out.println("Enter your name: ");
        String n=System.console().readLine();
        System.out.println("Following is the line inputted");
        c.printf("%s",n);
    }
}
