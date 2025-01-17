package src.TerminalOper.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", 25),
                new Employee("Martin", 30),
                new Employee("Sam", 25),
                new Employee("John", 35)
        );

        //groupingBy will group the elements based on the what you are specifying like age in this caseS

        Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(emp -> emp.getAge()));


        map.forEach((age, emp) -> {
            System.out.println(age);
            emp.forEach(System.out::println);
        });
    }
}
