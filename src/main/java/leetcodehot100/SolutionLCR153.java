package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]

 */
class SolutionLCR153 {
    //结果集，用来保存我们需要的结果
    List<List<Integer>> res = new ArrayList<>();
    //路径，用于保存我们每一步的路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null) return;
        // 说明node不为null
        //说明可以往下面的节点继续走了
        //往path中添加一条记录
        path.add(node.val);
        //既然都添加记录了,需要把target减少
        target -= node.val;
        //先判断这个是不是叶子节点，并且target是否为0
        if (node.left == null && node.right == null && target == 0) {
            //这里为了保证之后的path不被修改，所以是新建的，
            //如果不新建的话。path可能会被后面的过程给修改
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.remove(path.size() - 1);
    }
}