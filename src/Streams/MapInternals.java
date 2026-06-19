package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapInternals {
    static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(10,20,23,40,70,45,67,84);
        List<Integer>nums=new ArrayList<>();
        nums=numbers.stream().map(n->n*3).collect(Collectors.toList());
        System.out.println(nums);
    }
}
