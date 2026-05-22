package ArrayAndHashing;

import java.util.*;

class Pair {
    int data;
    int freq;
    Pair(int data, int freq){
        this.data = data;
        this.freq = freq;
    }
}
//347. Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/
public class KMostFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        //first make the frequency map
        Map<Integer, Integer> fm = new HashMap<>();
        for(int num : nums){
            fm.put(num, fm.getOrDefault(num, 0) + 1);
        }

        //now create a freq array
        int n = nums.length;
        List<Integer>[] freqArr = new List[n + 1];
        //now add all the element to freqArr
        for(int key : fm.keySet()){
            int freq = fm.get(key);
            if(freqArr[freq]== null){
                freqArr[freq] = new ArrayList<>();
            }
            freqArr[freq].add(key);
        }

        //now iterate from last to first
        int[] ans = new int[k];
        int index = 0;
        for(int i=n; i>=0 && index<k; i--){
            if(freqArr[i]!=null){
                for(int num : freqArr[i]){
                    ans[index++] = num;
                    if(index == k){
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
