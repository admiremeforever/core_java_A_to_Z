package collections.Streams;

import java.util.Arrays;
import java.util.List;

public class TernaryOperatorForEachandToArray {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(99,2,3,2,3,6,7,1,3,5,6,99);

        list.stream().filter(x->x>=6).forEach(x-> System.out.println(x));

        Object[] objectArr = list.stream().filter(x->x>=6).toArray();
        System.out.println(objectArr.length);
        Integer[] intArr = list.stream().filter(x->x>=56).toArray(x->new Integer[x]);

    }
}
