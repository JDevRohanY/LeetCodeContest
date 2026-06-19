package ThirtyDayPrep.Day_1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
       //create the freq map
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //once map is created, create a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1]-b[1];
        });
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }

        //now iterate on all the keys that are left
        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index] = pq.poll()[0];
            index++;
        }
        return ans;
    }
}
