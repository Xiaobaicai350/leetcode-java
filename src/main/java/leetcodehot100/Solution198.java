package leetcodehot100;

class Solution198 {
    public int rob(int[] nums) {
        //安全性校验
        if (nums.length == 0) {
            return 0;
        }
        //如果只有一家，只偷这一家就行
        if (nums.length == 1) {
            return nums[0];
        }
        //如果不止有一家，执行下面的逻辑

        //创建dp数组，长度为房屋的个数
        //dp[i]表示前i+1间房屋能偷窃到的最多钱数
        int[] dp = new int[nums.length];
        //初始化dp数组
        dp[0] = nums[0];//意思是前1间房子最多能偷dp[0]块钱
        dp[1] = Math.max(nums[0], nums[1]);//意思是前2间房子最多能偷dp[1]块钱
        for (int i = 2; i < nums.length; i++) {
            /*
             之后只有两种可能
             1.偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋。偷窃总金额为前 k−2 间房屋的最高总金额+第 k 间房屋的金额。
             2.不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
             之后取这两者的最大值就好了
             */
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}