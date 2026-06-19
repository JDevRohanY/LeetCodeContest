package ThirtyDayPrep.Day_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        //I want to group the same anagram word together
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String s : strs){
            //sort the string
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            //now join back
            String key = String.valueOf(arr);
            //now check if this key is there or not
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        //now we have added all the string
        List<List<String>> ans = new ArrayList<>();
        for(String key : anagramMap.keySet()){
            ans.add(anagramMap.get(key));
        }
        return ans;
    }
}
