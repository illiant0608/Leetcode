import java.util.ArrayList;
import java.util.List;

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int rotten_nums = 0;
        int rotting_times = 0;
        while (true) {
            if (isAllRotten(grid)) return rotting_times;
            else {
                int cur_nums = rotting(grid);
                rotting_times++;
                if (rotten_nums == cur_nums) break;
                rotten_nums = cur_nums;
            }
        }

        return -1;
    }

    public boolean isAllRotten(int[][] grid) {
        for (int i = 0;i < grid.length;i++)
            for (int j = 0;j < grid[0].length;j++)
                if (grid[i][j] == 1) return false;
        return true;
    }

    private int rotting(int[][] grid) {
        int num = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0;i < grid.length;i++)
            for (int j = 0;j < grid[0].length;j++)
                if (grid[i][j] == 2) list.add(new int[] {i, j});

        for (int[] pos : list) {
            if (pos[0] != 0)
                grid[pos[0] - 1][pos[1]] = grid[pos[0] - 1][pos[1]] == 0 ? 0 : 2;
            if (pos[0] != grid.length - 1)
                grid[pos[0] + 1][pos[1]] = grid[pos[0] + 1][pos[1]] == 0 ? 0 : 2;
            if (pos[1] != 0)
                grid[pos[0]][pos[1] - 1] = grid[pos[0]][pos[1] - 1] == 0 ? 0 : 2;
            if (pos[1] != grid[0].length - 1)
                grid[pos[0]][pos[1] + 1] = grid[pos[0]][pos[1] + 1] == 0 ? 0 : 2;
        }

        return list.size();
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}};
        RottingOranges_994 test = new RottingOranges_994();
        System.out.println(test.orangesRotting(grid));
    }
}
