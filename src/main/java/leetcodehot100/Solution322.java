package leetcodehot100;

/**
 * 这道题跟完全平方数很像
 * 当遍历到i的时候，
 */

/*
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
dp[0]=0
dp[1]=1
dp[2]=1
dp[3]=dp[3-1]+1=2
dp[4]=dp[4-2]+1=2
dp[5]=dp[5-5]+1=1
dp[6]=dp[6-5]+1=2
dp[7]=dp[7-5]+1=2
dp[8]=dp[8-5]+1=3
dp[9]=dp[9-5]+1=3
dp[10]=dp[10-5]+1=2
dp[11]=dp[11-5]+1=3
 */
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i]的含义是：当总金额为i的时候。可以凑成总金额的最少硬币数为dp[i]
        int[] dp = new int[amount + 1];
        //初始化dp数组。
        dp[0] = 0;
        //当凑成总金额的最少硬币数dp[1]为-1的时候，说明凑不齐
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            //遍历面值coins数组
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }

//    public static void main(String[] args) {
//        new Solution322().coinChange(new int[]{1, 2, 5}, 11);
//    }
}