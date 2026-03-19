package collections.Streams;

import java.util.*;

public class DistinctAndSorted {
    public static void main(String[] args) {
        //remove duplicates
        List<Integer> list = Arrays.asList(99,2,3,2,3,6,7,1,3,5,6,99);

        List<Integer> resultList = list.stream().distinct().toList();
        System.out.println(resultList);

        List<Integer> sortedList = resultList.stream().sorted().toList();
        System.out.println(sortedList);
        List<Integer> reverseSortedList = resultList.stream().sorted((a,b)->b-a).toList();
        System.out.println(reverseSortedList);


    }
}
