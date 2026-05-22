package ArrayAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
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
        //calculate the frequency of each element using a hashmap
        Map<Integer, Integer> fm = new HashMap<>();
        for(int num : nums){
            fm.put(num, fm.getOrDefault(num, 0) + 1);
        }
        //frequency map is calculated
        //maintain a heap of size k - min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.freq - b.freq;
        });

        for(Integer key : fm.keySet()){
            if(pq.size() == k){
                //check the current freq > pq.top
                if(pq.peek().freq < fm.get(key)){
                    pq.poll();
                    pq.add(new Pair(key, fm.get(key)));
                }
            }else{
                pq.add(new Pair(key, fm.get(key)));
            }
        }

        //now we have k most frequent element
        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll().data;
        }
        return ans;
    }
}
