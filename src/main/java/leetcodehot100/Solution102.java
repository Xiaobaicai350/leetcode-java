package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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