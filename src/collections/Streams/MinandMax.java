package collections.Streams;

import java.util.Arrays;
import java.util.List;

public class MinandMax {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,2,3,6,7,1,3,5,6,99);


        int min = list.stream().filter(x->x>6).min((a,b)->a-b).orElse(-1);
        int max = list.stream().filter(x->x<=7).min((a,b)->b-a).orElse(-1);
        System.out.println(max);
        long count = list.stream().filter(x->x>8).count();
        System.out.println(count);
        //mics

        //anyMatch
        boolean HasValueGreaterThen99 = list.stream().anyMatch(x->x>99);
        //
        System.out.println(HasValueGreaterThen99);

      int firstValue = list.stream().filter(x->x>5).findFirst().orElse(-1);
        System.out.println(firstValue);
    }
}
