package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //first create the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        //initialize the list
        for(int i=0; i<numCourses; i++){
            adjacencyList.add(i, new ArrayList<>());
        }
        //add the edges to the adjacency list
        for(int i=0; i<prerequisites.length; i++){
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //now create an array of state
        int[] state = new int[numCourses];
        for(int i=0 ; i<numCourses; i++){
            if(state[i]==0){
                if(findCycle(adjacencyList, state, i)) return false; //cycle is there
            }
        }
        return true;
    }

    public boolean findCycle(List<List<Integer>> adjacencyList, int[] state, int node){
        //mark the current state of the node as visiting
        state[node] = 1;
        for(int neighbour :  adjacencyList.get(node)){
            if(state[neighbour] == 1) return true;
            if(state[neighbour] == 0) {
                if(findCycle(adjacencyList, state, neighbour)) return true;
            }
        }
        state[node] = 2;
        return false;
    }
}
