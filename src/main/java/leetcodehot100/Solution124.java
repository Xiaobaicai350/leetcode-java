package leetcodehot100;

import entity.TreeNode;

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。

示例 1：
输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6

示例 2：
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
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
        // 返回节点的最大贡献值（注意最大贡献值，只是和左右其中一边的和）
        return node.val + Math.max(leftGain, rightGain);
    }
}
