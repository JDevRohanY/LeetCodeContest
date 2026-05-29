package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return new ArrayList<>(List.of(0));
        }
        //first make the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        //create the degree array
        int[] degree = new int[n];
        //intialise the list
        for(int i=0; i<n; i++){
            adjacencyList.add(i, new ArrayList<>());
        }
        //now iterate on edges
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            //add both u-> v and v -> u (undirected)
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        //add all the node with degree 1 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }
        int remaining = n;
        while(remaining>2){
            remaining -= queue.size();
            for(int i=0; i<queue.size(); i++){
                int curr = queue.poll();
                for(int node : adjacencyList.get(curr)){
                    degree[node]--;
                    if(degree[node]==1){
                        queue.add(node);
                    }
                }
            }
        }
        //the one which are remaining are the answer
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }

        return ans;
    }
}
