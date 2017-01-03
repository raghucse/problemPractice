package test;

/**
 * Created by raghu on 1/1/2017.
 */
public class test2 {
    public static void main(String[] args) {
        int n =6;
        String format = "%"+n+"s";

        StringBuilder hash = new StringBuilder();
        for(int i=0 ; i < n ; i++)
        {
            hash.append("#");
            System.out.printf(format,hash.toString());
            System.out.println();

        }
        String s = "000";
        String s1 = "100";
        String s2 = "0101";
        String s3 = "001";

        System.out.println(Integer.parseInt(s)+" "+Integer.parseInt(s1)+" "+Integer.parseInt(s3));


    }
}
