package JavaSE8;

import java.io.InputStream;
import java.util.stream.IntStream;

/**
 * Created by raghu on 12/29/2016.
 */
public class InputStreamOperations {

    public static void main(String[] args) {

        int a[] = new int[]{1,2,3,4};


        IntStream.of(a).
                filter(value -> value%2 ==0)
                    .sorted()
                .forEach(value -> {
            System.out.printf("%d   \n ", value);
        });

        IntStream.of(a).
                filter(value -> value%2 ==0)
                .sorted().map(v -> v * 10)
                .forEach(value -> {
                    System.out.printf("%d     \n  ", value);
                });

        //sorted returns a IntStream I guess
        System.out.println(IntStream.of(a).sorted());
    }

}
