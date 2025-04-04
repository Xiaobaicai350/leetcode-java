package leetcodehot100;

import entity.TreeNode;

/*
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：
例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。
叶节点 是指没有子节点的节点。

示例 1：
输入：root = [1,2,3]
输出：25
解释：
从根到叶子节点路径 1->2 代表数字 12
从根到叶子节点路径 1->3 代表数字 13
因此，数字总和 = 12 + 13 = 25

示例 2：
输入：root = [4,9,0,5,1]
输出：1026
解释：
从根到叶子节点路径 4->9->5 代表数字 495
从根到叶子节点路径 4->9->1 代表数字 491
从根到叶子节点路径 4->0 代表数字 40
因此，数字总和 = 495 + 491 + 40 = 1026
 */
class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 计算从根节点到各个叶节点所形成路径代表数字的总和
     * @param node 当前正在处理的子树的根节点。
     * @param prevSum 从整棵树的根节点到当前 node 节点的父节点所形成路径代表的数字。
     * @return
     */
    public int dfs(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        //如果到叶子节点了，直接返回
        if (node.left == null && node.right == null) {
            return sum;
        } else {//如果不是叶子节点，就还需要往下遍历
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}
