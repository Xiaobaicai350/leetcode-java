package leetcodehot100;

import java.util.Arrays;

/**
 * 这道题跟完全平方数很像
 * 当遍历到coin[j]的时候，只需要加上dp[i-coin[j]],就是可能是dp[i]了，但是要算出一个最小的当dp[i]
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
        //用一个比较大的值（但是不要用最大值，会溢出）把他填满，方便后面进行比较
        Arrays.fill(dp, amount + 100);
        //初始化dp数组。
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //遍历面值coins数组
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //如果dp[amount]比amount还大，说明没有任何一种硬币组合能组成总金额
        //所以返回-1
        if (dp[amount] > amount) {
            return -1;
        } else {//否则就是正常情况
            return dp[amount];
        }
    }

}