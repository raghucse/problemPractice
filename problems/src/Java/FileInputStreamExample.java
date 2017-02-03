package Java;

import java.io.*;

/**
 * Created by raghu on 1/4/2017.
 */
public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fi = new FileInputStream("StreamLines");
            int i = 0;
            while ( (i = fi.read()) != -1) {
                System.out.println((char) i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
