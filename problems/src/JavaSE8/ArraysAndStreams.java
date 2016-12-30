package JavaSE8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by raghu on 12/29/2016.
 */
public class ArraysAndStreams {
    public static void main(String[] args) {
            Integer a[] = {1,2,4,3,5};

        System.out.println(Arrays.stream(a).sorted().collect(Collectors.toList()));


        List<Integer> greaterThan4= Arrays
                        .stream(a)
                        .filter(value -> value <= 4)
                        .collect(Collectors.toList());

        System.out.println(greaterThan4);

        System.out.println(greaterThan4.stream().sorted().collect(Collectors.toList()));

        // Using String
        String s[] ={"Green", "Red", "Black", "Grape", "Orange"};

        List<String> upper = Arrays.stream(s).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(upper);

        System.out.println(Arrays.stream(s).filter(string -> string.compareToIgnoreCase("m") >0 ).collect(Collectors.toList()));
    }
}
