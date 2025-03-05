package leetcodehot100;

/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

示例 1 ：
输入：nums = [2,2,1]
输出：1

示例 2 ：
输入：nums = [4,1,2,1,2]
输出：4

示例 3 ：
输入：nums = [1]
输出：1
 */
// 这道题的核心思想是:
//  两个相同的值异或值为0 比如 1^1=0
//  一个0和一个值相异或 得到的是这个值 1^0=1
//  所以就可以得出来只出现一次的数字了
class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}