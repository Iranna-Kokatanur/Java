package src.intermediateOper;

import java.util.List;

public class Reduce {

    List<Integer> list = java.util.Arrays.asList(1,2,3,4,5,6);


    //0 is the initial value, a is the accumulator, b is the value
    //a+b is the lambda expression
    // It will make the sum of all the elements in the list
    public static void main(String[] args) {

        Reduce red = new Reduce();
        int sum = red.list.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum);

    }

}
