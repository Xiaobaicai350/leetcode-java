package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeLast();
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
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