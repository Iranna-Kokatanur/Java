package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Distinct {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5,5,6);

        //distinct will remove the duplicate elements from the stream

        list.stream().distinct().forEach(System.out::println);
    }
}
