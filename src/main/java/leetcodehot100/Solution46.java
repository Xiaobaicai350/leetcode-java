package leetcodehot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
/*
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    ArrayList<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(0, nums);
        return res;
    }

    private void dfs(int index, int[] nums) {
        if (index == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>(temp);
            res.add(cur);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    temp.add(nums[i]);
                    dfs(i + 1, nums);
                    temp.remove(temp.size() - 1);
                    used[i] = false;
                }
            }
        }
    }


}