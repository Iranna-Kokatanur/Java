package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Peek {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //peek is used to debug the stream, it will take input param as consumer

        // peak will not modify the stream, it will just print the stream based on the consumer
        list.stream().peek(System.out::println).map(n -> n * n).forEach(System.out::println);
    }
}
