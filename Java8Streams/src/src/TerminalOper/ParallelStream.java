package src.TerminalOper;

import java.util.stream.LongStream;

public class ParallelStream {

    public static void main(String[] args) {

        //parallelStream will return a parallel stream

        long[] longArray = new long[20];

        for(int i = 0; i<longArray.length; i++){
            longArray[i] = i + 1;
        }

        //calculate the factorial using sequential stream
        long time = System.currentTimeMillis();
        long factorial = LongStream.of(longArray).reduce(1, (long a, long b) -> a * b);

        System.out.println(factorial);
        System.out.println("Time taken by sequential stream: " + (System.currentTimeMillis() - time));

        //calculate the factorial using parallel stream
        time = System.currentTimeMillis();
        long factorialParallel = LongStream.of(longArray).parallel().reduce(1, (long a, long b) -> a * b);

        System.out.println(factorialParallel);
        System.out.println("Time taken by parallel stream: " + (System.currentTimeMillis() - time));

    }   //if there is heavy computation then parallel stream is faster than sequential stream
}
