package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Filter {

    static List<Integer> list = Arrays.asList(1,2,3,4,5,6);

    //filter will take input param as predicate

    public static void main(String[] args) {

        list.stream().filter(n -> n%2 == 0).forEach(System.out::println);

    }
}
