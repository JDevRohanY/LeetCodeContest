package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacificMatrix = new boolean[row][col];
        boolean[][] atlantaMatrix = new boolean[row][col];

        pacificMatrix = constructPacific(pacificMatrix, heights);
        atlantaMatrix = constructAtlanta(atlantaMatrix, heights);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(pacificMatrix[i][j] && atlantaMatrix[i][j]){
                    ans.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return ans;

    }

    public boolean[][] constructPacific(boolean[][] pacificMatrix, int[][] heights){
        //add the first row and the first col cell to the queue
        int rows= heights.length;
        int cols = heights[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //add the first row cell to the queue and mark visited
        for(int j=0; j<cols; j++){
            pacificMatrix[0][j] = true;
            queue.addLast(new int[]{0, j});
        }
        //same do for first col
        for(int i=1; i<rows; i++){
            pacificMatrix[i][0] = true;
            queue.addLast(new int[]{i, 0});
        }

        //now the first row, and first col added to queue and both mark as visited too
        //now we will iterate on queue and find the cells who height is greater than current
        while(!queue.isEmpty()){
            int[] currCell = queue.pollFirst();
            int currX = currCell[0];
            int currY = currCell[1];
            for(int[] dir : directions){
                //check if we can iterate in all four directions or not
                if(currX+dir[0]>=0 && currX+dir[0]<rows
                        && currY+dir[1]>=0 && currY+dir[1]<cols
                        && !pacificMatrix[currX + dir[0]][currY + dir[1]]
                        && heights[currX+dir[0]][currY+dir[1]]>=heights[currX][currY]
                ){
                    //add to queue and mark visited
                    queue.addLast(new int[]{currX+dir[0], currY+dir[1]});
                    pacificMatrix[currX + dir[0]][currY + dir[1]] = true;
                }
            }
        }
        return pacificMatrix;
    }

    public boolean[][] constructAtlanta(boolean[][] atlantaMatrix, int[][] heights){
        //add the last row and the last col cell to the queue
        int rows= heights.length;
        int cols = heights[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //add the last row cell to the queue and mark visited
        for(int j=0; j<cols; j++){
            atlantaMatrix[rows-1][j] = true;
            queue.addLast(new int[]{rows-1, j});
        }
        //same do for last col
        for(int i=0; i<rows-1; i++){
            atlantaMatrix[i][cols-1] = true;
            queue.addLast(new int[]{i, cols-1});
        }

        //now the first row, and first col added to queue and both mark as visited too
        //now we will iterate on queue and find the cells who height is greater than current
        while(!queue.isEmpty()){
            int[] currCell = queue.pollFirst();
            int currX = currCell[0];
            int currY = currCell[1];
            for(int[] dir : directions){
                //check if we can iterate in all four directions or not
                if(currX+dir[0]>=0 && currX+dir[0]<rows
                        && currY+dir[1]>=0 && currY+dir[1]<cols
                        && !atlantaMatrix[currX + dir[0]][currY + dir[1]]
                        && heights[currX+dir[0]][currY+dir[1]]>=heights[currX][currY]
                ){
                    //add to queue and mark visited
                    queue.addLast(new int[]{currX+dir[0], currY+dir[1]});
                    atlantaMatrix[currX + dir[0]][currY + dir[1]] = true;
                }
            }
        }
        return atlantaMatrix;
    }
}
