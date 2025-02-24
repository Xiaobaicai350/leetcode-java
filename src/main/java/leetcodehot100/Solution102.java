package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            // 如果整棵树都为空，直接返回空列表
            return res;
        }

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先将根节点入队
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 保存当前层的节点数量，然后处理当前层
            // 第一次处理的时候因为已经将根节点入队，所以不用特殊处理
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                //出队
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                tmpList.add(node.val);
            }

            // 将每一层的结果放入结果集
            res.add(tmpList);
        }

        return res;
    }
}