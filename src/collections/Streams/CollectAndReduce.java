package collections.Streams;

import java.util.Arrays;
import java.util.List;

public class CollectAndReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(99,2,3,2,3,6,7,1,3,5,6,99);

        int sum = list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
        //collect to aata hi hai
    }
}
