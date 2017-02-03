package Java;

import java.io.*;

/**
 * Created by raghu on 1/7/2017.
 */
public class DataOutputStreamExample {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream("testout.txt");
        DataOutputStream data = new DataOutputStream(file);
        data.writeInt(65);
        data.writeFloat(123.45F);
        data.flush();
        data.close();
        System.out.println("Succcess...");

        InputStream input = new FileInputStream("testout.txt");
        DataInputStream inst = new DataInputStream(input);
        System.out.println(inst.readInt());
        System.out.println(inst.readFloat());

    }
}
