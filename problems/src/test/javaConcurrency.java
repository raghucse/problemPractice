package test;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by raghu on 2/3/2017.
 */
public class javaConcurrency {



    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Scanner sc = new Scanner(System.in);
        String dirPath = sc.nextLine();
        File directory = new File(dirPath);
        List<Callable<Integer>> callSet = new ArrayList<Callable<Integer>>();
       // Set<File> files =  new HashSet<File>();


        for (File f :directory.listFiles()) {
            callSet.add(()->{
                FileReader fw;
                BufferedReader br;
                fw = new FileReader(f);
                br =  new BufferedReader(fw);
                String line;
                int count = 0;
                while ((line = br.readLine()) != null){
                    String[] str = line.split(" ");
                    count +=  str.length;
                }
                return count;
            });
        }
        /*
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        }*/
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> result = exec.invokeAll(callSet);
        int totalResult = 0;

        for(Future<Integer> a: result){
            totalResult += a.get();
        }
        System.out.println(totalResult);
    }


}
