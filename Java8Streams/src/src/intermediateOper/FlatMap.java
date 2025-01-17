package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class FlatMap {

    public static void main(String[] args) {

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"));

        //flatmap will flat the elements like a,b,c,d
        list.stream().flatMap(l -> l.stream()).forEach(System.out::println);

        System.out.println(list.stream().flatMap(l -> l.stream()).reduce((a, b) -> a+b).get());

    }
}
