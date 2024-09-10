package leetcodehot100;

import entity.TreeNode;

/**
 * 感觉这道题有点贪心的思想
 */
class Solution124 {
    //赋值为最小的值，方便进行Math.max()比较
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 该函数计算二叉树中的一个节点的最大贡献值
     *
     * @param node
     * @return
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // 计算以当前节点为根的时候最大的路径和，也就是左的最大值+右的最大值+当前节点的最大值
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewPath);
        // 返回节点的最大贡献值（注意最大贡献值，只是左右其中一边的和）
        return node.val + Math.max(leftGain, rightGain);
    }
}
