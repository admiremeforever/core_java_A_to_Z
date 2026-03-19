package collections.Streams;

import java.util.Arrays;
import java.util.List;

public class MapToInt {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(99,2,3,2,3,6,7,1,3,5,6,99);

        int sumInt= list.stream().mapToInt(x->x).sum();


        System.out.println(sumInt);
    }
}
