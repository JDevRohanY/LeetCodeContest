package WeekelyContest497;
/*
Link to problem : https://leetcode.com/contest/weekly-contest-497/problems/find-the-degree-of-each-vertex/
 */
public class DegreeOfEachVertex {
    static void main() {
        int[][] matrix = {{0,1,1},{1,0,1},{1,1,0}};
        int[] ans = findDegrees(matrix);
        for(int i = 0; i<ans.length ; i++){
            System.out.print(ans[i] + ", ");
        }
    }

    public static int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        for(int i=0 ; i<matrix.length; i++){
            int count = 0;
            for(int j=0 ; j<matrix[i].length; j++){
                if(matrix[i][j]==1){
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }

}
