package src.TerminalOper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Min {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //min will return the minimum element from the stream

        Optional<?> min = list.stream().min((i, j) -> i.compareTo(j));

        System.out.println(min.get());

    }
}
