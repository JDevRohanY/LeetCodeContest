package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();
        //Make a queue
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val)); //cloned the start node
        while(!q.isEmpty()){
            Node curr = q.poll();
            //get all the neighbour
            for(Node neighbour : curr.neighbors){
                //check if the curr neighbour is visited or not
                if(!visited.containsKey(neighbour)){
                    q.offer(neighbour);
                    visited.put(neighbour, new Node(neighbour.val));
                }
                //connect this to the clone graph
                visited.get(curr).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }
}
