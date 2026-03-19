package collections.Streams;

import java.util.ArrayList;
import java.util.*;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1002);
        list.add(3005);
        list.add(459);
        list.add(45691);
        list.add(3000);
        list.add(3001);

        long result = list.stream().filter(a->a>3000).count();
        System.out.println(result);


    }
}
