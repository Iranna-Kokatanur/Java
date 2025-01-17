package src.TerminalOper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirst {

    public static void main(String[] args) {

        java.util.stream.Stream<Integer> stream = java.util.stream.Stream.of(1,2,3,4,5,6,7,8,9,10);

        //findFirst will return the first element from the stream

        Optional<?> first = stream.findFirst();

        System.out.println(first.get());

        //or

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Optional<?> fir = list.stream().findFirst();

        System.out.println(fir.get());


    }
}
