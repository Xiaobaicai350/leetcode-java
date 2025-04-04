package simple;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterationTreeExample {
    // 前序遍历的迭代实现
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // 先将右子节点压入栈，因为栈是后进先出的
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
    // 中序遍历的迭代实现
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // 当当前节点不为空或者栈不为空时继续遍历
        while (current != null || !stack.isEmpty()) {
            // 遍历到最左节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 现在在最左边的节点，访问当前节点
            current = stack.pop();
            result.add(current.val);

            // 转向右子树
            current = current.right;
        }

        return result;
    }

    // 后序遍历的迭代实现
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
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

        // 调用前序遍历方法
        List<Integer> preorderResult = preorderTraversal(root);
        System.out.println("前序遍历结果: " + preorderResult);

        // 调用中序遍历方法
        List<Integer> inorderResult = inorderTraversal(root);
        System.out.println("中序遍历结果: " + inorderResult);

        // 调用后序遍历方法
        List<Integer> postorderResult = postorderTraversal(root);
        System.out.println("后序遍历结果: " + postorderResult);
    }
}