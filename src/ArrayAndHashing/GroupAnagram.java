package ArrayAndHashing;

import java.util.*;

//49. Group Anagrams
//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagram {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //make the key and store it
            Map<String, List<String>> mp = new HashMap<>();
            List<List<String>> ans = new ArrayList<>();
            for(String s : strs){
                //make the key
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                mp.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }
            //iterate on map and add to the ans
            for(String key : mp.keySet()){
                ans.add(mp.get(key));
            }
            return ans;
        }
    }
}
