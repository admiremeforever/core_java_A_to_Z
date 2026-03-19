package collections.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample3FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1,2,3));
        numbers.add(Arrays.asList(9,6,8));
        numbers.add(Arrays.asList(90,70,99));
        System.out.println(numbers);

        List<Integer> resultList = numbers.stream().flatMap(x->x.stream()).collect(Collectors.toList());

        System.out.println(resultList);

        List<List<String>> stringList = Arrays.asList(Arrays.asList("SEETA","GEETA","BABITA"),
                Arrays.asList("HEMA","JAYA","SUSMA"),Arrays.asList("SABKI","PASAND","NIRMA"));

        System.out.println(stringList);
        List<String> resultString = stringList.stream().flatMap(x->x.stream()).collect(Collectors.toList());

        System.out.println(resultString);


    }
}
