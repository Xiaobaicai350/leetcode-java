package leetcodehot100;

import entity.TreeNode;

/*
给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
两节点之间路径的 长度 由它们之间边数表示。

示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

示例 2：
输入：root = [1,2]
输出：1
 */

/**
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径 可能经过 也可能 不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数(注意这里)表示。
 */
class Solution543 {
    //用来存储结果
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * 这个函数的意思就是以node为节点的子树的最长深度
     *
     * @param node
     * @return
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //分别记录以左右支为根结点的最长长度
        int lLen = dfs(node.left);
        int rLen = dfs(node.right);
        //更新结果
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen) + 1;// 返回该节点为根的子树的最长深度
    }

}