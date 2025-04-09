package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个。

示例 1：
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。

示例 2：
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]

示例 3：
输入: candidates = [2], target = 1
输出: []
 */
class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> cur = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return res;
    }

    //需要注意的是start是为了避免添加重复的结果，所以需要记录start
    //并且需要注意的是如果res直接添加cur，cur是一个引用会被其他给修改，这样得到的结果全是空的，不合题意，所以需要新建一个temp
    private void dfs(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                cur.add(candidates[i]);
                dfs(candidates, target, start + 1, sum + candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
