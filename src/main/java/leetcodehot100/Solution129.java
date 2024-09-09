package leetcodehot100;

import haohao.TreeNode;

class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //prevSum代表node之前节点的值
    public int dfs(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        //如果到叶子节点了，直接返回
        if (node.left == null && node.right == null) {
            return sum;
        } else {//如果不是叶子节点，就还需要往下遍历
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}
