package UberQuestion;

import java.util.*;

public class MinimumTime {
    static void main() {

    }

    public static int getMinTime(int n, int d, List<Integer> x, List<Integer> y){
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i =0; i<n ; i++){
            parent[i] = i;
        }

        Map<Integer, List<Integer>> byRow = new HashMap<>();
        Map<Integer, List<Integer>> byCol = new HashMap<>();

        for(int i =0 ; i< n ; i++){
            byRow.computeIfAbsent(y.get(i), k -> new ArrayList<>()).add(i);
            byCol.computeIfAbsent(x.get(i), k-> new ArrayList<>()).add(i);
        }

        for(List<Integer> group : byRow.values()){
            group.sort(Comparator.comparingInt(i -> x.get(i)));
            for(int k = 1; k < group.size(); k++) {
                int a = group.get(k-1), b = group.get(k);
                if(Math.abs(x.get(a) - x.get(b)) <= d) {
                    union(parent, rank, a, b);
                }
            }
        }

        int components = 0;
        for(int i=0; i<n; i++){
            if(find(parent, i)==i) components++;
        }
        return components;
    }

    private static int find(int[] parent, int i ){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void union(int[] parent, int[] rank, int a, int b){
        int ra = find(parent, a), rb = find(parent, b);

        if(ra == rb) return;

        if(rank[ra] < rank[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        }

        parent[rb] = ra;
        if(rank[ra] == rank[rb]) rank[ra]++;
    }
}
