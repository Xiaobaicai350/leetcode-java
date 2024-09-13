package writtenExamination.途虎养车0912;

public class Solution1 {


    //[1,3,1],[-1,-1,1][4,-1,1]
    public static void main(String[] args) {
        int[][] ints = new int[3][3];
        ints[0] = new int[]{1, 3, 1};
        ints[1] = new int[]{-1, -1, 1};
        ints[2] = new int[]{4, -1, 1};
        System.out.println(new Solution().maxPriceValue(ints));
    }
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int maxPriceValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 初始化第一行
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                dp[0][j] = grid[0][j];
            } else if (grid[0][j] != -1 && grid[0][j - 1] != -1) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            } else {
                dp[0][j] = Integer.MIN_VALUE;
            }
        }

        // 初始化第一列
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                dp[i][0] = grid[i][0];
            } else if (grid[i][0] != -1 && grid[i - 1][0] != -1) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            } else {
                dp[i][0] = Integer.MIN_VALUE;
            }
        }

        // 动态规划填表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    int fromTop = grid[i][j] + (dp[i - 1][j] == Integer.MIN_VALUE ? 0 : dp[i - 1][j]);
                    int fromLeft = grid[i][j] + (dp[i][j - 1] == Integer.MIN_VALUE ? 0 : dp[i][j - 1]);
                    dp[i][j] = Math.max(fromTop, fromLeft);
                }
            }
        }

        // 检查最后一个元素是否有效
        return dp[m - 1][n - 1] == Integer.MIN_VALUE ? 0 : dp[m - 1][n - 1];
    }



}