package leetcodehot100;

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
    // 最终的结果集
    private List<List<Integer>> ans = new ArrayList<>();
    // 用来存储每一个小组合结果
    private List<Integer> path = new ArrayList<>();

    // 标记这个位置上的数字是否被使用了
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {//如果到这里说明该收获结果了
            List<Integer> tmp = new ArrayList<>(path);
            ans.add(tmp);
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 如果这个数字没被用过，就使用一下
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, index + 1);
                    //开始回溯
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}