package hardCode;


import entity.TreeNode;

public class BinarySearchTree {
    TreeNode root;

    // 插入节点（这个是包装了一下下面的insertR方法）
    void insert(int val) {
        root = insertR(root, val);
    }

    // 插入节点，返回值为根节点
    public TreeNode insertR(TreeNode root, int val) {
        // 如果树为空，返回新的节点
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        // 否则，递归地向下查找正确的位置并插入
        if (val < root.val) {
            root.left = insertR(root.left, val);
        } else if (val > root.val) {
            root.right = insertR(root.right, val);
        }
        // 返回根节点
        return root;
    }

    // 中序遍历（二叉搜索树的性质就是中序遍历的顺序是有序的）
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }


    //二叉搜索树的中序遍历是有序的
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* 插入节点 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        /* 中序遍历二叉排序树 */
        System.out.println("中序遍历二叉排序树:");
        tree.inorder(tree.root);
    }
}

