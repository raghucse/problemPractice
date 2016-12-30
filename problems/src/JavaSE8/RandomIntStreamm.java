package JavaSE8;

import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by raghu on 12/30/2016.
 */
public class RandomIntStreamm {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();


        System.out.printf("%-10s%-6s", "Number", "Frequency\n");
        random.ints(6_000_000,1,7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach(
                        (num, frequency) -> {
                            System.out.printf("%-10d%-6d\n", num, frequency);
                        }
                );


    }
}
