package Java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by raghu on 1/4/2017.
 */
public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fs = new FileOutputStream("StreamLines");
            fs.write(2222);
            String characters = "This is character writing testing";
            byte[] b = characters.getBytes();
            fs.write(b);
        //    fs.flush();
            fs.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
