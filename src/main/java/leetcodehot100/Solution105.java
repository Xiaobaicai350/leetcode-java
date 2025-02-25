package leetcodehot100;

import entity.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

示例 1:
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]

思路：
    前序遍历的第一个元素是根节点。
    在中序遍历中找到根节点的位置，根节点左边的元素属于左子树，右边的元素属于右子树。
    递归地构建左子树和右子树
 */

/**
 * 前序遍历 根左右
 * 中序遍历 左根右
 */
/*
preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 */
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 前序遍历的第一个元素是根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int rootIndexInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInorder = i;
                break;
            }
        }
        //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        /*
        preorder = [9]
        inorder = [9]
         */
        // 递归构建左子树
        root.left = buildTree(
                //Arrays.copyOfRange 方法是“左闭右开”的区间
                Arrays.copyOfRange(preorder, 1, rootIndexInorder + 1),
                Arrays.copyOfRange(inorder, 0, rootIndexInorder)
        );
        /*
        preorder = [20, 15, 7]
        inorder = [15, 20, 7]
         */
        // 递归构建右子树
        root.right = buildTree(
                Arrays.copyOfRange(preorder, rootIndexInorder + 1, preorder.length),
                Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length)
        );

        return root;
    }
}



