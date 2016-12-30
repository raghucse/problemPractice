package JavaSE8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by raghu on 12/30/2016.
 */
public class ProcressingEmployee {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Raghavendra", "Venkatesh", 4000, "IT"),
                new Employee("Raghavendra", "Akash", 4000, "IT"),
                new Employee("Thomsam", "Jack", 9000, "IT"),
                new Employee("Cat", "Kam", 9000, "HR"),
                new Employee("Dog", "cat", 6000, "HR"),
                new Employee("Apoorva", "Sam", 19000, "HR")
        };

        List<Employee> e = Arrays.asList(employees);

        e.stream().forEach(System.out::println);

        //----------------------------------------------
        System.out.println( );
        System.out.println("Employees  salary between 4000 to 9000");
        Predicate<Employee> fourTonineThousand = em -> (em.getSalary() > 4000 && em.getSalary() <=9000);

        e.stream().filter(fourTonineThousand).forEach(System.out::println);

        System.out.println("\nUsing comparator");
        e.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println("\n \nFirst employee");
        System.out.println(e.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst().get());

        System.out.println("\n\n\n Compare using comparator");

        Function<Employee, String> firstName = Employee::getFirstName;
        Function<Employee, String> lastName = Employee::getLastName;

        Comparator<Employee> firstThenLast= Comparator.comparing(firstName).thenComparing(lastName);
        e.stream().sorted(firstThenLast).forEach(System.out::println);

        System.out.println("\n\n Reverse Comparision");
        e.stream().sorted(firstThenLast.reversed()).forEach(System.out::println);

        System.out.println("\n\n Mapping the Employee objects to a String");
        e.stream().map(Employee::getFirstName).distinct().sorted().forEach(System.out::println);

        System.out.println("\n\n  sorted and mape");
        e.stream().sorted(firstThenLast).map(Employee::getFirstName).forEach(System.out::println);


        System.out.println("\n\nMapping the employees by th departMent grp");
        Map<String, List<Employee>> grpBuDept2 = e.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        grpBuDept2.forEach(
                (dept, employ) ->{
                    System.out.println(dept);
                    employ.forEach(employee -> System.out.println(employee));
                }
        );



        Map<String, Long> grpByDept = e.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
        grpByDept.forEach(
                (dept, count) ->
                {
                    System.out.println(dept+" has "+count+" Employees");
                }
        );

        //I  think sum want values to be in double
        System.out.println("\n\nCalculating employee salary");
        System.out.println(e.stream().mapToDouble(Employee::getSalary).sum());

        System.out.println("\n\nCalculating using reduce");
        System.out.println(e.stream().mapToDouble(Employee::getSalary).reduce(0, (v1,v2)-> v1+v2));

        System.out.println("\n\nAverage employee salary");
        System.out.println(e.stream().mapToDouble(Employee::getSalary).average().getAsDouble());
    }
}
