package src.TerminalOper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Max {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //max will return the minimum element from the stream

        //min or max will take comparator as argument

        Optional<?> max = list.stream().max(Comparator.naturalOrder());

        System.out.println(max.get());

    }
}
