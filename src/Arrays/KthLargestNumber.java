package Arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthLargestNumber {
    static void main() {
        int[][] matrix = {{5,2},{1,6}};
        System.out.println(kthLargestNumber(matrix, 5));
    }
    public static int kthLargestNumber(int[][] matrix, int k){
        //build the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //find the adjacent cells values
                int top = 0;
                int left = 0;
                int topLeft = 0;
                if(i-1>=0){
                    top = matrix[i-1][j];
                }
                if(j-1>=0){
                    left = matrix[i][j-1];
                }
                if(i-1>=0 && j-1>=0){
                    topLeft = matrix[i-1][j-1];
                }
                matrix[i][j] = matrix[i][j] ^ top ^ left ^ topLeft;
                uniqueSet.add(matrix[i][j]);
            }
        }
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                pq.add(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
