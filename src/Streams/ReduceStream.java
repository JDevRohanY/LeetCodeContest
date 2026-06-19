package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStream {
    static void main(String[] args) {
        // String array to combine
        List<Integer> list = Arrays.asList(5, 7, 2, 3, 6, 8, 9);
        Optional<Integer> min = list.stream().reduce((a, b) -> Math.min(a, b));
        min.ifPresent(System.out::println);

    }
}
