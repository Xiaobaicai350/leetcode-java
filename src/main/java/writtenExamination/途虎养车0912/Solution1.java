package writtenExamination.途虎养车0912;

public class Solution1 {


    //[1,3,1],[-1,-1,1][4,-1,1]
    public static void main(String[] args) {
        int[][] ints = new int[3][3];
        ints[0] = new int[]{1, 3, 1};
        ints[1] = new int[]{-1, -1, 1};
        ints[2] = new int[]{4, -1, 1};
        new Solution().maxPriceValue(ints);
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
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -10000;
            }
        }
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j]!=-1)
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }


}