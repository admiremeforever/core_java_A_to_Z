package collections.Streams;

import java.util.ArrayList;
import java.util.List;

public class SkipAndLimit {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1002);
        list.add(3005);
        list.add(459);
        list.add(45691);
        list.add(3000);
        list.add(3001);

        List<Integer> resultListLimit = list.stream().limit(3).toList();
        System.out.println(resultListLimit);
        List<Integer> resultListLskip = list.stream().skip(3).toList();
        System.out.println(resultListLskip);
    }
}
