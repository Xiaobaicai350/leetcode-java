package leetcodehot100;

import haohao.TreeNode;

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