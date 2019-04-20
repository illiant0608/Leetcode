/**
 * Leetcode 63
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0;i < grid.length;i++) {
            if (obstacleGrid[i][0] == 1) {
                grid[i][0] = -1; break;
            } else grid[i][0] = 1;
        }
        for (int i = 0;i < grid[0].length;i++) {
            if (obstacleGrid[0][i] == 1) {
                grid[0][i] = -1; break;
            } else grid[0][i] = 1;
        }

        for (int i = 1;i < grid.length;++i)
            for (int j = 1;j < grid[0].length;++j)
                grid[i][j] = -obstacleGrid[i][j];




        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1;i < grid.length;++i) {
            for (int j = 1;j < grid[0].length;++j) {
                if (grid[i][j] == -1) continue;
                if (grid[i-1][j] != -1) grid[i][j] += grid[i-1][j];
                if (grid[i][j-1] != -1) grid[i][j] += grid[i][j-1];
            }
        }

        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return grid[grid.length - 1][grid[0].length - 1] == -1 ? 0 : grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePath2 test = new UniquePath2();
        int[][] grid = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
        System.out.println(test.uniquePathsWithObstacles(grid));
    }
}
