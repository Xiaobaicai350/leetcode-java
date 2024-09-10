package leetcodehot100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 找第k小的元素，直接中序遍历得到有序数组，然后根据下标就可以得到了
 */
class Solution230 {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        //给list赋值
        inorder(root);
        return list.get(k-1);
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