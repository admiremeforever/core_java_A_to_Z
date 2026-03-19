package collections.Streams;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("POOJA");
        nameList.add("SNEHA");
        nameList.add("KATIYA");
        nameList.add("BALLU");
        nameList.add("WUA");
        nameList.add("HU");
        nameList.add("HA");
        List<String> resultLit =nameList.stream().filter(x-> x.length()<=4).collect(Collectors.toList());

        System.out.println(resultLit);

        List<String> lowerCaseString = nameList.stream().map(x->x.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowerCaseString);
    }


}
