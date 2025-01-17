package src.TerminalOper.collect;

import java.util.Arrays;
import java.util.List;

public class collect {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //collect will collect the elements from the stream and store it in the collection

        List<Integer> evenNumbers = list.stream().filter(n -> n%2 == 0).collect(java.util.stream.Collectors.toList());

        System.out.println(evenNumbers);
    }
}
