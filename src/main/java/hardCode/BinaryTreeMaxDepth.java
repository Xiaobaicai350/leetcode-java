package hardCode;

import entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//迭代方法求二叉树的最大深度
public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
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
