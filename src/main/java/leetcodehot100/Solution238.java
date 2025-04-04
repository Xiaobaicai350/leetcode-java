package leetcodehot100;

/*
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。


示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]
 */
// [1,2,3,4]
// left ：[1,1,2,6]
// right: [24,12,4,1]
// ans  : [24,12,8,6]

/**
 * 这道题要注意好边界的问题，和怎么对左数组赋值和如何给右数组赋值的就好了
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 计算出数组长度
        int n = nums.length;
        // left用来存储除i以外的左边数组之积
        int[] left = new int[n];
        // right用来存储除i之外的右边数组之积
        int[] right = new int[n];
        // ans用来存储i的左右数组之积
        int[] ans = new int[n];
        // 初始化左数组
        left[0] = 1;
        // 初始化右数组
        right[n - 1] = 1;
        // 从左往右 给左数组赋值
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // 从右往左 给右数组赋值
        for (int i = n - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        // 结果集等于相应的左数组乘相应的右数组
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
