package src.TerminalOper.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", 25),
                new Employee("Martin", 30),
                new Employee("Sam", 25),
                new Employee("John", 35)
        );

        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy((emp -> emp.getAge() > 25)));

        //partitioningBy will partition the elements based on the what you are specifying like age in this case


        // > 25
        map.get(true).forEach((System.out::println));

        // <= 25
        map.get(false).forEach((System.out::println));


    }
}
