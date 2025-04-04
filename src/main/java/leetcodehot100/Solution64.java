package leetcodehot100;

/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
 */
/*
跟上一题差不多，都是通过构建dp数组，然后遍历得到dp的值，因为这道题下一个dp数组的值可以通过上面的和左面的元素进行推导出来
如果这道题不规定只能向下或者向右移动，就不能这样做了
一共分为三种情况：
    当i>0且j=0时，dp[i][0]=dp[i-1][0]+grid[i][0]
    当i=0且j>0时，dp[0][j]=dp[0][j-1]+grid[0][j]
    当i>0且j>0时，dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
*/
class Solution64 {
    public int minPathSum(int[][] grid) {
        //安全性校验
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //计算矩形的行和列的长度
        int rows = grid.length;
        int columns = grid[0].length;

        // dp[i][j]表示从左上角到（i,j）位置的最小路径和，由于dp是可以推出来的，所以可以用动态规划
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        // 对于在第一列的元素，只能向下移动到达
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 对于在第一行的元素，只能向右移动到达
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 对于其他位置的元素，可以从上方或左方到达
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 最后到右下角的dp数组即是最小路径和
        return dp[rows - 1][columns - 1];
    }
}