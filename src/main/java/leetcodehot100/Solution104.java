package leetcodehot100;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最大的深度
 */
class Solution104 {
    //递归方法
    public int maxDepth(TreeNode root) {
        if (root == null) {//递归出口
            return 0;
        } else {
            //抽象的求出左支和右支的最大值
            int max = Math.max(maxDepth(root.left), maxDepth(root.right));
            //然后加上根节点这一层的高度就是1了
            return max + 1;
        }
    }
    //迭代方法求二叉树的最大深度
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // 将当前节点的子节点加入队列
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++; // 完成一层的遍历，深度加1
        }

        return depth;
    }
}