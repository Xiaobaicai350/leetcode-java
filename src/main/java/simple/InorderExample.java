package simple;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderExample {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // 当当前节点不为空或者栈不为空时继续遍历
        while (current != null || !stack.isEmpty()) {
            // 遍历到最左节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            //现在在最左边的节点，
            // 访问当前节点
            current = stack.pop();
            result.add(current.val);

            // 转向右子树
            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {
        // 构建一个二叉树
        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 调用中序遍历方法
        List<Integer> result = inorderTraversal(root);

        // 输出结果 result = [4, 2, 5, 1, 6, 3, 7]。
        System.out.println(result);
    }
}