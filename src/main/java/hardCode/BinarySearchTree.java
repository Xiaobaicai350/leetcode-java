package hardCode;


import entity.TreeNode;

public class BinarySearchTree {
    TreeNode root;

    // 插入节点（这个是包装了一下下面的insertR方法）
    void insert(int val) {
        root = insertR(root, val);
    }

    // 递归插入节点，返回值
    public TreeNode insertR(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {//如果当前要插入的值，比当前遍历的节点小，那么就往左边插入
            //如果就正好插入到了空节点，那么就新建一个节点
            //如果就没有插入到空节点，那么就继续递归，其实这段代码就等于root.left=root.left了
            root.left = insertR(root.left, val);
        } else if (root.val < val) {
            root.right = insertR(root.right, val);
        }
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

