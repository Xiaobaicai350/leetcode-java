package leetcodehot100;

import haohao.TreeNode;

/**
 * 求最大的深度
 */
class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {//递归出口
            return 0;
        } else {
            //抽象的求出左支和右支的最大值
            int max = Math.max(maxDepth(root.left), maxDepth(root.right));
            //然后加上根节点这一层的高度就是1了
            return max + 1;
        }
    }
}