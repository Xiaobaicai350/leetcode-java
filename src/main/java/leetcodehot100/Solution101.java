package leetcodehot100;

import haohao.TreeNode;


class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    //dfs返回左右子树是否对称
    private boolean dfs(TreeNode left, TreeNode right) {
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