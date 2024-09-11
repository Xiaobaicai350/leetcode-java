package leetcodehot100;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        // 递归出口，说明越界了或者当前土地不是1
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        // 为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 0。
        grid[cur_i][cur_j] = 0;
        int ans = 1; // 初始化为1，因为当前块也是1

        // 递归调用四次，分别对应四个方向
        ans += dfs(grid, cur_i, cur_j + 1); // 向右
        ans += dfs(grid, cur_i, cur_j - 1); // 向左
        ans += dfs(grid, cur_i + 1, cur_j); // 向下
        ans += dfs(grid, cur_i - 1, cur_j); // 向上

        return ans;
    }

}
