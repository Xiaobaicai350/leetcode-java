package leetcodehot100;

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果 nums 的总和为奇数，则不可能平分成两个子集
        //这里其实就是进行了剪枝，优化性能
        if (sum % 2 == 1) {
            return false;
        }

        //计算出一个子集的总和值。
        int target = sum / 2;
        // 可以把这道题目转换成01背包问题
        // dp数组表示的含义是：dp[i]表示背包的容量是i的时候，放进物品的最大重量是dp[i]
        //然后现在问题就是转换成了：背包容量为target，用剩下的物品只放一次能不能装满背包。
        //dp[i]=max(dp[i],dp[i-num]+num)因为
        int[] dp = new int[target + 1];

        for (int num : nums) {
            /*
            倒序遍历：这里使用倒序遍历是为了保证每个物品只能被放入背包一次。如果使用正序遍历，在更新 dp[j] 时，可能会重复使用同一个物品。
                例如，当更新 dp[j] 时，dp[j - num] 可能已经包含了当前物品 num，这样就会导致物品被重复放入。
            遍历范围：从 target 开始，到 num 结束。这是因为只有当背包容量 j 大于等于物品重量 num 时，才有可能将该物品放入背包。
             */
            // 这里一定得是倒序遍历才能保证只能放一次
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }
}
