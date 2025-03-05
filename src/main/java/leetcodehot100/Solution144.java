package leetcodehot100;


import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}