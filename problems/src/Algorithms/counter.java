package Algorithms;

/**
 * Created by raghu on 3/24/2017.
 */
public class counter {
    public static void main(String[] args) {
        long x  = System.currentTimeMillis();
        new counter().count(0);
        long y  = System.currentTimeMillis();

        System.out.println(y-x);
        //new counter().count(0, x, 0);


    }

   public void count(int count, long x , long y){
        if(count == 5000) {
            System.out.println(y-x);
            System.exit(0);
        }
        count ++;
        y  = System.currentTimeMillis();
        count(count, x, y);
    }

    public void count(int count){
        if(count == 5000) {
            return;
        }
        count ++;
        count(count);
    }
}
