package leetcodehot100;

/**
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */

/**
 * 递推公式是dp[i] = min(dp[i-j*j]) + 1;
 * 这个1其实加的就是(j*j)这个值的结果,因为假设现在枚举到j了，我们还需要取dp[i-j*j]的值
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
 dp[12]=dp[12-2*2]+1=3   注意这个，dp[i-j*j]不是j越大dp值就越小，需要进行记录最小值。
 dp[13]=dp[13-3*3]+1=2
 */
class Solution279 {
    public int numSquares(int n) {
        //dp[i]的意思是：当整数值为i的时候，和为完全平方数的最少数量是dp[i]
        int[] dp = new int[n + 1];
        //初始化dp数组，但是其实默认创建都是0
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                //dp[i-j*j]的意思是：当整数值为i-j*j的时候，完全平方数的最小数量是dp[i-j*j]
                //把问题规模缩小成计算dp[i-j*j]
                //找出前面最小的dp，因为按照上面的推，不一定j越大dp越小，所以要记录最小值
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}