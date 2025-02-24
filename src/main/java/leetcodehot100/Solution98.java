package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
- 节点的左子树只包含 小于 当前节点的数。
- 节点的右子树只包含 大于 当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。

示例 1：
输入：root = [2,1,3]
输出：true

示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */

/**
 * 这道题的思路就是先给二叉树转换成数组（用中序遍历），然后验证这个数组是否有序就可以了，因为二叉搜索树的中序遍历必然是有序的
 */
class Solution98 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        //中序遍历 给list数组赋值
        inorder(root);
        //验证数组是否有序
        for (int i = 1; i < list.size(); i++) {
            //将后一个与前一个进行相比。注意这里等于也不行，具体看题目中的二叉树的定义
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        //如果之前的数组有序，也就是升序，返回true
        return true;
    }

    /**
     * 中序遍历，目的是给list数组赋值
     *
     * @param node
     */
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}