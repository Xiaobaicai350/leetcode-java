package leetcodehot100;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
/**
 * 刚开始的时候误会这道题的意思了，原来是可以不连续，也是子序列。。。
 */
class Solution300 {
    public int lengthOfLIS(int[] nums) {
        // dp数组表示的含义是： 以nums[i]为结尾的最长递增子序列的长度是dp[i]
        //递推公式为：dp[i] = max(dp[i], dp[j] + 1);
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

    public static void main(String[] args) {
        new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}