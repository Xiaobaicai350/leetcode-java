package leetcodehot100;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

示例 1:
输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:
输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

/*
考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，
这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
如果当前位置是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
具体的动态规划思路是，对于第i个元素，最大乘积可以由以下三者中的最大值得到：前一个元素结尾的最大乘积乘以当前元素、当前元素本身、前一个元素结尾的最小乘积乘以当前元素。
同样地，最小乘积可以由类似的三者中的最小值得到。通过遍历数组并不断更新maxF和minF数组，最终得到最大乘积的结果。
 */

class Solution152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];  // 用于保存以当前位置元素结尾的子数组的最大乘积
        int[] minF = new int[length];  // 用于保存以当前位置元素结尾的子数组的最小乘积
        /**
         * 将原始数组 nums 的值复制到两个新的数组 maxF 和 minF 中，用于初始化这两个数组。
         */
        System.arraycopy(nums, 0, maxF, 0, length);  // 初始化maxF数组为原始数组
        System.arraycopy(nums, 0, minF, 0, length);  // 初始化minF数组为原始数组
        for (int i = 1; i < length; ++i) {
            // 更新maxF[i]，取三者中的最大值：前一个元素结尾的最大乘积 * 当前元素、当前元素、前一个元素结尾的最小乘积 * 当前元素
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            // 更新minF[i]，取三者中的最小值：前一个元素结尾的最小乘积 * 当前元素、当前元素、前一个元素结尾的最大乘积 * 当前元素
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];  // 初始化结果为第一个元素结尾的最大乘积
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);  // 更新结果为所有元素结尾的最大乘积中的最大值
        }
        return ans;  // 返回最大乘积结果
    }
}