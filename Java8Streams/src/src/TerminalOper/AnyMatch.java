package src.TerminalOper;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {

    public static void main(String[] args) {


        //anyMatch will return true if any of the element in the stream matches the given predicate

        boolean anyMatch = java.util.stream.Stream.of(1,2,3,4,5,6,7,8,9,10).anyMatch(n -> n%2 == 0);

        System.out.println(anyMatch);

        //or

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        boolean any = list.stream().anyMatch(n -> n%2 == 0);

        System.out.println(any);

    }
}
