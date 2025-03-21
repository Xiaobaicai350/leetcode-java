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
 * 其实基本的思想就是不停的更新cover的最大值，就找最大的cover，如果不符合题意就直接返回了
 * cover的意思就是范围到数组的哪个下标了
 */
class Solution45 {
    public int jump(int[] nums) {
        int length = nums.length;
        //end其实是记录每一步可以走到哪里
        int end = 0;
        // 用于记录最大可以走过的位置
        int cover = 0;
        // 用于记录步数，用于返回结果
        int steps = 0;
        // 注意这里，没有必要访问最后一个元素
        // 因为访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了，
        // 所以没有必要访问最后一个元素，也就是说最后一个元素不管是几都无所谓
        for (int i = 0; i < length - 1; i++) {
            // 遍历，遍历得到最远的位置之后，如果走到了那个位置的话，就记录步数
            //2 5 6 7
            cover = Math.max(cover, i + nums[i]);
            //0 2
            if (i == end) {
                end = cover;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        new Solution45().jump(new int[]{2,3,1,1,4});
    }
}
