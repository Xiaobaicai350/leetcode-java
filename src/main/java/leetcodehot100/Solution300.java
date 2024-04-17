package leetcodehot100;

/**
 * 刚开始的时候误会这道题的意思了，原来是可以不连续，也是子序列。。。
 */
class Solution300 {
    public int lengthOfLIS(int[] nums) {
        // dp数组表示的含义是： 以nums[i]为结尾的最长递增子序列的长度是dp[i]
        int[] dp = new int[nums.length];
        //初始化dp数组为1，因为最少都是1（以本数字为结尾）
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        //作为返回值
        int res = dp[0];
        //从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            //内层遍历是从第一个元素进行遍历，目的是找出来前面有几个元素比当前的值小，然后就直接取他的dp最大值就可以了
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//如果后面的比前面的大，说明需要更新dp了
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //给结果赋值，取出数组最大的dp[i]
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }
}