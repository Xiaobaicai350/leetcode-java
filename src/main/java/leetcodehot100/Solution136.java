package leetcodehot100;

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