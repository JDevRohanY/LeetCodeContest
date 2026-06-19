package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyAndFindFirst {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Pen", "Book", "pen", "Pencil");
        Optional<String> ele = stringList.stream().findAny();
        System.out.println(ele.get());
    }
}
