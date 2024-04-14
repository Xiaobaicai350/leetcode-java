package leetcodehot100;

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
            cover = Math.max(cover, i + nums[i]);
            if (i == end) {
                end = cover;
                steps++;
            }
        }
        return steps;
    }
}
