package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]
 */
/**
 * 本题可以抽象出一颗树，向一边走就是不要这个值，向另一边走就是要这个值
 */
class Solution78 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        //从下标为0开始
        recur(0, nums, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param i 目前到达了树的第几层
     * @param nums
     * @param chosen
     */
    private void recur(int i, int[] nums, List<Integer> chosen) {
        //如果到达树的末尾了，就可以开始返回了
        if (i == nums.length) {
            //拷贝临时的结果数组
            List<Integer> tmp = new ArrayList<>(chosen);
            res.add(tmp);
        } else {
            // 不选当前元素的逻辑
            recur(i + 1, nums, chosen);

            // 选当前元素的逻辑，把当前元素加入到临时的结果数组中
            chosen.add(nums[i]);
            recur(i + 1, nums, chosen);

            // 回溯操作，撤销选择，以便尝试其他可能
            chosen.remove(chosen.size() - 1);
        }
    }
}