package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by raghu on 1/3/2017.
 */
public class FileHandling {
    public static void main(String[] args) throws Exception{
        new FileHandling().fileHandling();
    }

    public void fileHandling() throws FileNotFoundException {
        File f = new File("StreamLines");

        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);

        while (true)
        {

        }



    }
}
