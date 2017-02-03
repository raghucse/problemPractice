package Java;

import java.util.Date;

/**
 * Created by raghu on 1/8/2017.
 */
public class StringFormatting {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.printf("%tD", today);
        System.out.printf("Date in dd/mm/yy format %td/%tm/%ty %n", today,today,today );
        System.out.println();
        System.out.printf("Today is %tB %te, %tY %n", today,today,today);


        System.out.printf("Amount : %08d %n" , 221);
        System.out.printf("Amount : %8d %n" , 221);

        System.out.printf("positive number : +%d %n", 1534632142);
        System.out.printf("negative number : -%d %n", 989899);

        //printing floating point number with System.format()
        System.out.printf("%f %n", Math.E);

        //3 digit after decimal point
        System.out.printf("%.3f %n", Math.E);

        //8 charcter in width and 3 digit after decimal point
        System.out.printf("%8.3f %n", Math.E);

        System.out.printf("Total %,d messages processed today", 10000000);
    }
}
