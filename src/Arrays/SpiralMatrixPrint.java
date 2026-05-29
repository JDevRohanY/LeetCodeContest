package Arrays;
/*
1 2 3
4 5 6
7 8 9
 */
public class SpiralMatrixPrint {
    static void main() {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(grid);
    }
    public static void printMatrix(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int startX = 0;
        int endX = n-1;
        int startY = 0;
        int endY = m-1;

        while(startX<=endX && startY<=endY) {
            // print first row (left → right)
            for (int i = startY; i <= endY; i++) {
                System.out.print(grid[startX][i] + " ");
            }

            // print last col (top → bottom)
            for (int i = startX + 1; i <= endX; i++) {
                System.out.print(grid[i][endY] + " ");
            }

            // print last row reverse (right → left)
            if (startX != endX) {
                for (int i = endY - 1; i >= startY; i--) {
                    System.out.print(grid[endX][i] + " ");
                }
            }

            // print first col reverse (bottom → top)
            if (startY != endY) {
                for (int i = endX - 1; i > startX; i--) {
                    System.out.print(grid[i][startY] + " ");
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
    }
}
