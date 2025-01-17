package src.intermediateOper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorted {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,1,1,-1,-121);

        //sorted will sort the stream based on the natural order takes comparator as input
        list.stream().sorted().forEach(System.out::println);

        //reverse order
        list.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);

        //or
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }
}
