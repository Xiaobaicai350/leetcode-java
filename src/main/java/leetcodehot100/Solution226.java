package leetcodehot100;

import entity.TreeNode;


class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //进行翻转根节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归的翻转左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}