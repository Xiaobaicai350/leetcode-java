package leetcodehot100;

//一道技巧题目，手动试试，记住就好了。
//这道题先翻转前半部分，再翻转后半部分，再整个翻转是一样能过的，不过数组的下标要变一下
/*
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
 */
class Solution189 {
    public void rotate(int[] nums, int k) {
        // 防止数组长度小于k
        k %= nums.length;
        // 翻转整个数组
        reverse(nums, 0, nums.length - 1);
        // 翻转前半部分
        reverse(nums, 0, k - 1);
        // 翻转后半部分
        reverse(nums, k, nums.length - 1);
    }

    // 翻转方法
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}