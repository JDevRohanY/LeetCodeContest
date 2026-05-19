package Arrays;

/*
https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/?envType=problem-list-v2&envId=array
 */
public class SubmatrixWithXandY {
    static void main(String[] args) {

    }

    private int numberOfSubmatrices(char[][] grid) {
        //first we need to make prefix sum array and contains x
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefixSumGrid = new int[n][m];
        boolean[][] containX = new boolean[n][m];

        int totalCount = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int top = 0;
                int left = 0;
                int topleft = 0;

                boolean topX = false;
                boolean leftX = false;
                if(i-1>=0){
                    top = prefixSumGrid[i-1][j];
                    topX = containX[i-1][j];
                }
                if(j-1>=0){
                    left = prefixSumGrid[i][j-1];
                    leftX = containX[i][j-1];
                }
                if(i-1>=0 && j-1>=0){
                    topleft = prefixSumGrid[i-1][j-1];
                }

                int curr = 0;
                boolean currX = false;
                if(grid[i][j]=='X'){
                    curr =1;
                    currX = true;
                }else if(grid[i][j]=='Y'){
                    curr = -1;
                }else{
                    curr = 0;
                }

                prefixSumGrid[i][j] = curr + top + left - topleft;
                containX[i][j] = currX || topX || leftX;

                if(prefixSumGrid[i][j] == 0 && containX[i][j]){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}
