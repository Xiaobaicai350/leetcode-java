package leetcodehot100;

class Solution53 {
    public int maxSubArray(int[] nums) {
        // dp[n]表示以第n个元素为结尾的最大子数组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {//如果大于等于0再加
                dp[i] = dp[i - 1] + nums[i];
            } else {//否则就还不如重新开始，因为前面已经小于0了，还不如从头开始
                dp[i] = nums[i];
            }
            //更新max的值
            max=Math.max(dp[i],max);
        }
        return max;
    }
}