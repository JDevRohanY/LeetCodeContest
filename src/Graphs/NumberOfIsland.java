package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;

        int total = 0;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                //check if curr cell is 1 or not
                if (grid[i][j] == '1') {
                    total++;
                    //create a queue
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j]='0';
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        //first mark the current cell
                        int[] curr = q.poll();
                        //iterate on all four directions
                        for (int[] d : directions) {
                            //check each direction
                            int x = curr[0];
                            int y = curr[1];
                            if (x + d[0] >= 0 &&
                                    y + d[1] >= 0 &&
                                    x + d[0] < rows &&
                                    y + d[1] < col &&
                                    grid[x + d[0]][y + d[1]] == '1') {
                                grid[x+d[0]][y+d[1]] = '1';
                                q.offer(new int[]{x + d[0], y + d[1]});
                            }
                        }
                    }
                }
            }
        }
        return total;
    }
}
