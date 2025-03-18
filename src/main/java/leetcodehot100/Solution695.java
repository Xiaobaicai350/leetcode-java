package leetcodehot100;

/*
给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

示例 1：
输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。

示例 2：
输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0
 */
public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    //dfs的含义是，从当前位置开始，向四个方向进行递归，返回当前岛屿的面积
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
