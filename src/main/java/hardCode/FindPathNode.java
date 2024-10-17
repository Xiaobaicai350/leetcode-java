package hardCode;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathNode {
    /*
    本思路是从根节点开始，递归地在左子树和右子树中查找目标节点，如果在某个子树中找到了目标节点，那么这个子树的根节点就是路径的一部分。
    我们可以通过回溯的方式，将找到的路径记录下来。
     */
    public List<TreeNode> findPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        findPathHelper(root, target, path);
        return path;
    }

    private boolean findPathHelper(TreeNode node, TreeNode target, List<TreeNode> path) {
        // 如果节点为空，返回false，这个也是退出条件
        if (node == null) {
            return false;
        }

        // 将当前节点添加到路径中（回溯开始）
        path.add(node);
        // 如果当前节点就是目标节点，返回true
        if (node == target) {
            return true;
        }
        // 在左子树中递归查找目标节点
        if (findPathHelper(node.left, target, path)) {
            return true;
        }
        // 在右子树中递归查找目标节点
        if (findPathHelper(node.right, target, path)) {
            return true;
        }
        // 如果当前节点的左右子树中都没有找到目标节点，说明当前节点不在路径中，将其从路径中移除（回溯结束）
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        // 构建一个简单的测试二叉树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 目标节点
        TreeNode target = root.left.right; // 节点 5

        // 寻找路径
        List<TreeNode> path = new FindPathNode().findPath(root, target);

        // 打印路径
        System.out.print("Path: ");
        for (TreeNode node : path) {
            System.out.print(node.val + " ");
        }
    }
}
