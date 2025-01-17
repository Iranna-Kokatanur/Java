package src.intermediateOper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {

        //premitive array
        int[] arr = {1, 2, 3, 4, 5};

        //Object array
        Integer[] arr2 = {1, 2, 3, 4, 5};

        final IntStream intStream = IntStream.of(arr);
        intStream.forEach(System.out::println);

        final Stream<Integer> intStream2 = Stream.of(arr2);
        intStream2.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().forEach(System.out::println);


    }
}