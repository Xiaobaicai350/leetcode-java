package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1：
输入：root = [1,2,3,null,5,null,4]
输出：[1,3,4]

示例 2：
输入：root = [1,2,3,4,null,null,null,5]
输出：[1,3,4,5]

示例 3：
输入：root = [1,null,3]
输出：[1,3]

示例 4：
输入：root = []
输出：[]


 */
/**
 * 这道题其实是借助一个队列来实现逐层遍历，只是在某一层的最后一个位置把最后一个节点取出来了而已。
 * 是跟逐层遍历二叉树一个思想
 */
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        //根结点入队
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //出队
                TreeNode node = queue.removeLast();
                if (node.left != null) {
                    //入队
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    //入队
                    queue.addFirst(node.right);
                }
                //如果遍历到最后一个节点，就把他添加到结果集中
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}