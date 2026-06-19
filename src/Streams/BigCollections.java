package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigCollections {
    public static void main(String[] args) {
        List<String> nameList1= Arrays.asList("Kunal","Karna","Rishabh");
        List<String>nameList2=Arrays.asList("Rangey","Pandey","Yogi");
        List<String>nameList3=Arrays.asList("Bhaiya","Mkoso","hdjjd");
        List<List<String>>finalList=Arrays.asList(nameList1,nameList2,nameList3);
        List<String>result= finalList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        System.out.println(result);
    }
}
