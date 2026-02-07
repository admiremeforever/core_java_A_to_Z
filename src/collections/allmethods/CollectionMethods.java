package collections.allmethods;

import java.util.*;
public class CollectionMethods {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(19);
       // System.out.println(list.size());
        Stack<Integer> stack = new Stack<>();
        stack.add(39);
        stack.add(29);
        stack.add(19);
        list.addAll(stack);

        list.addAll(stack);
        System.out.println(list);
        //be aware of this removeAll, it removes all the elements that is present and mathcing to the elements present in the
        //passed data collection
        list.removeAll(stack);
       // System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stack<Integer> stack1 = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        //System.out.println(list.equals(stack));


        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(299);
        list3.add(34);
          int value = Collections.max(list3);
        System.out.println(value);

        Collections.sort(list3);

        list3.forEach(System.out::println);






    }
}
