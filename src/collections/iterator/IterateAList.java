package collections.iterator;


import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class IterateAList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
   // Iterate using Iterator
        Iterator<Integer> listIterator = list.iterator();


        while(listIterator.hasNext()){
            int value = listIterator.next();
            System.out.println(value);

            if(value==3)
                listIterator.remove();

        }

//think why below code never works
//        while(list.iterator().hasNext()){
//            int value = list.iterator().next();
//            System.out.println(value);
//
//            if(value==3)
//                list.iterator().remove();
//
//        }


       //Iterate using For-Each
        System.out.println("Iterate using For-Each");
        list.forEach(System.out::println);

        list.forEach(a-> System.out.println(a));

        list.forEach(System.out::println);


    }
}
