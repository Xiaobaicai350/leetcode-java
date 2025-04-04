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
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        // 对候选人数组进行排序，便于剪枝操作
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    /**
     * 深度优先搜索辅助方法，递归寻找所有组合。
     *
     * @param candidates 候选人数组
     * @param start      开始搜索的索引位置，避免重复使用同一层的元素
     * @param target     当前需要减小到的目标值
     */

    private void dfs(int[] candidates, int start, int target) {
        // 如果目标值减为0，说明找到了一个合法组合
        if (target == 0) {
            // 复制当前路径并添加到结果列表中
            List<Integer> tmp = new ArrayList<>(path);
            res.add(tmp);
        } else {
            // 遍历从start开始的数组元素，尝试将每个元素加入组合
            for (int i = start; i < candidates.length; i++) {
                // 剪枝：如果当前元素大于剩余目标值，则后续元素也一定不满足条件，直接结束循环
                //也可以不剪枝，只是一个优化
                if (candidates[i] > target) {
                    break;
                }
                // 选择当前元素，将其加入路径
                path.add(candidates[i]);
                // 继续搜索，更新目标值为减去当前元素后的值，同时保持i不变允许重复选择
                dfs(candidates, i, target - candidates[i]);
                // 回溯，移除刚加入的元素，尝试其他组合
                path.remove(path.size() - 1);
            }
        }

    }
}
