package Graphs;

import java.util.ArrayDeque;

public class WallsAndGates {
    //every cell in the grid has three different values
    //first => 0 -> means gate
    //second => -1 -> means wall
    //third => INF -> means land
    public void wallsAndGates(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int INF = Integer.MAX_VALUE;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        //find all the cell where the gate is there
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    //this is gate
                    //add it to queue
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        //now we will work on the queue
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dist = 0;
        while (!queue.isEmpty()) {
            //find the size of the current queue
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.pollFirst();
                int currX = curr[0];
                int currY = curr[1];
                //now find all the neighbor cell
                for (int[] dir : dirs) {
                    if (currX + dir[0] >= 0
                            && currX + dir[0] < rows
                            && currY + dir[1] >= 0
                            && currY + dir[1] < cols
                            && grid[currX + dir[0]][currY + dir[1]] == INF
                            && grid[currX + dir[0]][currY + dir[1]] != -1) {
                        //add to queue and mark as visited
                        int[] cell = new int[]{currX + dir[0], currY + dir[1]};
                        queue.addLast(cell);
                        grid[currX+dir[0]][currY+dir[1]] = dist+1;
                    }
                }
            }
            dist++;
        }
    }
}
