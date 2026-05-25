package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //first create the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        //initialize the empty array list for each index
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            //add the u->v
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        //adjacency list is created
        //now create a queue
        Queue<Integer> queue = new LinkedList<>();
        //add the ones with indegree as 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            for (int next : adjacencyList.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return completed == numCourses;
    }
}
