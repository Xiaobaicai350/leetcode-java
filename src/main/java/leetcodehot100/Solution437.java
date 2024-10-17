package leetcodehot100;

import entity.TreeNode;

/*
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        //安全性校验，如果root为空，说明这棵树都不存在。
        if (root == null) {
            return 0;
        }
        //先计算以根节点为最高的节点的情况
        int res = dfs(root, targetSum);
        //递归左右子树，因为不一定非得从根节点进行，只要满足父子关系就可以。
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    /**
     * 这个函数的意思是：以root为根节点，可以找到res个符合题意的结果。
     *
     * @param root
     * @param targetSum
     * @return
     */
    private int dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }
}