package leetcodehot100;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果 nums 的总和为奇数，则不可能平分成两个子集
        if (sum % 2 == 1) {
            return false;
        }

        //计算出一个子集的总和值。
        int target = sum / 2;
        // 可以把这道题目转换成01背包问题
        // dp数组表示的含义是：dp[i]表示背包的容量是i的时候，放进物品的最大重量是dp[i]
        int[] dp = new int[target + 1];

        for (int num : nums) {
            // 这里一定得是倒序遍历才能保证只能放一次
            for (int j = target; j >= num; j--) {
                if (dp[j] < dp[j - num] + num) {
                    dp[j] = dp[j - num] + num;
                }
            }
        }
        return dp[target] == target;
    }
}
