package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Limit {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //limit will limit the number of elements from the stream

        list.stream().limit(2).forEach(System.out::println);

    }
}
