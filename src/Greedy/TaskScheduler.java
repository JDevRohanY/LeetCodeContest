package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        //create the freq array
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c -'A']++;
        }

        //once freq is made, add them in priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->{return b-a;});
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                queue.add(freq[i]);
            }
        }

        //once freq is made
        int time = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            //we can do at max n+1 task at a time
            for(int i =0; i<n+1; i++){
                if(!queue.isEmpty()){
                    int top = queue.poll();
                    temp.add(top-1);
                }
            }
            //add back the ones which have freq > 0
            for(int t : temp){
                if(t > 0){
                    queue.add(t);
                }
            }
            if(queue.isEmpty()){
                time+=temp.size();
            }else {
                time+=n+1;
            }
        }
        return  time;
    }
}
