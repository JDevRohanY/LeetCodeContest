package BinarySearchAndHeaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        //create the freq map
        int n = nums.length;
        Map<Integer, Integer> fm = new HashMap<>();
        for(int num : nums){
            fm.put(num, fm.getOrDefault(num, 0) + 1);
        }

        //create the priority queue of frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1]-b[1];
        });
        for(int key : fm.keySet()){
            pq.add(new int[]{key, fm.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index] = pq.poll()[0];
        }

        return ans;
    }
}
