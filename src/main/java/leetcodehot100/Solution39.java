package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution39 {
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates); // 排序，为剪枝做准备
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] candidates, int start, int target) {
        if (target == 0) { // target 不断减小，如果为0说明达到了目标值
            List<Integer> tmp = new ArrayList<>(path);
            res.add(tmp);
        }else {
            for (int i = start; i < candidates.length; i++) {
                //如果剩余值比这个元素的值还要小，直接返回，没有必要往下走了就
                if (candidates[i] > target) { // 剪枝，提前返回
                    break;
                }
                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
