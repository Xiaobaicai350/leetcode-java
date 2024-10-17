package leetcodehot100;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序遍历 根左右
 * 中序遍历 左根右
 */
/*
preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 */
class Solution105 {
    // 构造哈希映射，帮助我们快速定位根节点
    // key存储的是中序遍历的值，value存储的是对应的下标
    private Map<Integer, Integer> indexMap;
    private int[] preorder;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        this.preorder = preorder;
        this.preorderIndex = 0;
        this.indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, n - 1);
    }

    private TreeNode buildTree(int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int rootVal = preorder[preorderIndex++];
        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(rootVal);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(rootVal);
        // 递归地构造左子树，并连接到根节点
        root.left = buildTree(inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        root.right = buildTree(inorderRoot + 1, inorderRight);
        return root;
    }
}



