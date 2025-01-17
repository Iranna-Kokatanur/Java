package src.TerminalOper;

public class Sum {

    public static void main(String[] args) {

        //sum will return the sum of elements in the stream apply only on IntStream

        int sum = java.util.stream.Stream.of(1,2,3,4,5,6,7,8,9,10).mapToInt(i -> i).sum();

        System.out.println(sum);

        //or

        java.util.List<Integer> list = java.util.Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        // mapToInt is used to convert the stream of Integer to IntStream

        int s = list.stream().mapToInt(i -> i).sum();

        System.out.println(s);
    }
}
