package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

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