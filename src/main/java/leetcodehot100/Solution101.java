package leetcodehot100;

import entity.TreeNode;


/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true

示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
 */
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    //dfs函数返回左右子树是否对称
    private boolean dfs(TreeNode left, TreeNode right) {
        //需要判断三种情况：
        //1.左右子树都为空 这种是合理的
        //2.左右子树有一个为空 这种说明不对称了 不合理
        //3.左右子树都不为空，但是值不相等 不合理 不对称

        //如果左右支都为空，这种情况合理
        if (left == null && right == null) {
            return true;
        }
        //如果左支为空，右支不为空，这种情况不合理。
        if (left == null || right == null) {
            return false;
        }
        //如果左值不等于右值，这种情况也不合理
        if (left.val != right.val) {
            return false;
        }
        //接着继续验证
        // 左支的左支和右支的右支
        // &&
        // 左支的右支和右支的左支
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}