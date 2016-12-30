package JavaSE8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by raghu on 12/30/2016.
 */
public class StreamOfLines {
    public static void main(String[] args) throws IOException{
        Pattern p = Pattern.compile("\\s+");

        Map<String, Long> cnt = Files.lines(Paths.get("StreamLines")).map(lines ->lines.replaceAll("(?!')\\p{P}",""))
                .flatMap(line -> p.splitAsStream(line))
                .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
        System.out.println(cnt);


        //super
        cnt.entrySet().stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                        TreeMap::new, Collectors.toList()))
                .forEach((key, entry) ->
                        {
                            System.out.println(key+" "+ entry);
                        }
                );

    }



}
