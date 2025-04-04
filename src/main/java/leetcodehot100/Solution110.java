package leetcodehot100;

import entity.TreeNode;

/*
给定一个二叉树，判断它是否是 平衡二叉树

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：true

示例 2：
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false

示例 3：
输入：root = []
输出：true
 */

/*
平衡二叉树的定义是：二叉树的每个节点的左右子树的高度差的绝对值不超过 1，则二叉树是平衡二叉树
 */
class Solution110 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    // dfs 方法，用于递归计算节点的高度，同时检查平衡性
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归计算左右子树的高度
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 检查当前节点是否平衡
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        // 返回当前节点的高度
        return Math.max(left, right) + 1;
    }
}