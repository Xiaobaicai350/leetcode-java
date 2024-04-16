package leetcodehot100;

/**
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */

/**
 * 按照下面的题目进行模拟递推，就可以了，推出递推公式。
 */
/*
 dp[0]=0
 dp[1]=1
 dp[2]=dp[1]+1=2
 dp[3]=dp[2]+1=3
 dp[4]=dp[4-2*2]+1=1
 dp[5]=dp[5-2*2]+1=2
 dp[6]=dp[6-2*2]+1=3
 dp[7]=dp[7-2*2]+1=4
 dp[8]=dp[8-2*2]+1=2
 dp[9]=dp[9-3*3]+1=1
 dp[10]=dp[10-3*3]+1=2
 dp[11]=dp[11-3*3]+1=3
 dp[12]=dp[12-3*3]+1=4
 dp[13]=dp[13-3*3]+1=2
 */
class Solution279 {
    public int numSquares(int n) {
        //dp[i]的意思是：当整数值为i的时候，和为完全平方数的最少数量是dp[i]
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                //dp[i-j*j]的意思是：当整数值为i-j*j的时候，完全平方数的最小数量是dp[i-j*j]
                //把问题规模缩小成计算dp[i-j*j]
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution279().numSquares(13);
    }
}