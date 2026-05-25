package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        //first create the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        //initialize the list for each course
        for(int i=0; i<numCourses; i++){
            adjacencyList.add(i, new ArrayList<>());
        }
        //initalize the list
        //also create the indegree array
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            //to complete the [a,b] (b should get completed before a) => (b-> a)
            adjacencyList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        //create a queue
        Queue<Integer> queue = new LinkedList<>();
        //add the ones with indegree 0
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int completed = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans[completed] = curr;
            completed ++;
            for(int node : adjacencyList.get(curr)){
                indegree[node]--;
                if(indegree[node]==0){
                    queue.offer(node);
                }
            }
        }
        if(completed == numCourses) return ans;
        return new int[0];
    }
}
