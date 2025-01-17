package src.intermediateOper;

import java.util.Arrays;
import java.util.List;

public class Map {

    List<String> names = Arrays.asList("John", "Jane", "James", "Jack", "Jill");

    //intermediateOper.Map will take Function as input
    public static void main(String[] args) {
        Map map = new Map();
        map.names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
    }


}
