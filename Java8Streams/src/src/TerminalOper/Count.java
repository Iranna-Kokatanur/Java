package src.TerminalOper;

public class Count {

    public static void main(String[] args) {

        //count will return the number of elements in the stream

        long count = java.util.stream.Stream.of(1,2,3,4,5,6,7,8,9,10).count();

        System.out.println(count);

        //or

        java.util.List<Integer> list = java.util.Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        long c = list.stream().count();

        System.out.println(c);

    }
}
