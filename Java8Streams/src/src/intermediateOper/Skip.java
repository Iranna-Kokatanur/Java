package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Skip {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //skip will skip the number of elements from the stream

        list.stream().skip(2).forEach(System.out::println);

    }
}
