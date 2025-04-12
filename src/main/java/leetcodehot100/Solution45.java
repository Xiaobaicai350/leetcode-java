package leetcodehot100;

/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

示例 1:
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

示例 2:
输入: nums = [2,3,0,1,4]
输出: 2
 */

/**
 * 跟上题一样，但是侧重点不一样。需要注意的是，这道题必然可以走到终点，跟上题不太一样
 * 采用贪心的思想，每一步都选择能到达的最大位置就好了
 * cover的意思就是范围到数组的哪个下标了
 * 贪心选择性质指的是问题的全局最优解可以通过一系列局部最优选择得到。在本题里，每一步都选择能到达的最远位置，就是局部最优选择。
 * 在每一个位置 i 时，我们会计算从这个位置出发能到达的最远位置 i + nums[i]，并更新 cover 为当前所能到达的最远位置。当遍历到当前步的边界 end 时，就进行一次跳跃，把 end 更新为 cover。
 * 由于每一次跳跃都尽可能跳到最远的位置，这就保证了在跳跃次数最少的情况下覆盖更大的范围。每一次跳跃都是在当前可选的跳跃方案中选择了能到达最远位置的方案，通过不断重复这个局部最优选择，最终可以用最少的跳跃次数到达终点。
 */
class Solution45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int cover = 0;
        int end = 0;
        int step=0;
        for (int i = 0; i < len - 1; i++) {
            cover=Math.max(cover,i+nums[i]);
            if (i==end){
                step++;
                end=cover;
                System.out.println(end);
            }
        }
        return step;
    }

    public static void main(String[] args) {
        new Solution45().jump(new int[]{2, 3, 1, 1, 4});
    }
}
