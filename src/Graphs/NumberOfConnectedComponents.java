package Graphs;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;
        for(int i=0; i< edges.length; i++){
            if(dsu.union(edges[i][0], edges[i][1])){
                components--;
            }
        }
        return components;
    }
}
