package leetcodehot100;

import haohao.TreeNode;


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
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}