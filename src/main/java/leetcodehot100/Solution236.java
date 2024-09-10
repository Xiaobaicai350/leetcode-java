package leetcodehot100;

import entity.TreeNode;

/**
 * 这道题首先应该确定递归的终止条件
 * 其次是判断是否最近公共祖先是他们其中的一个
 * 之后以左右子树作为根节点传入进去得到以root.xx为根节点，返回p和q的公共祖先
 * 之后就可以进行判断了
 */
class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归的终止条件
        if (root == null) {
            return null;
        }
        //如果是根节点和左孩子相同或者是根节点和右孩子相同，直接返回根节点（这种情况下就是最近公共祖先是他们中的其中一个）
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        //以root.left为根节点，返回p和q的公共祖先
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        //以root.right为根节点，返回p和q的公共祖先
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        //如果两边都没有找到，说明这个最近公共祖先就是这个根节点
        if (leftRes != null && rightRes != null) {
            return root;
        } else if (leftRes == null) {//如果在左边没有找到，就说明最近公共祖先是右边这个
            return rightRes;
        } else {//else里面的是right为null，说明最近公共祖先是左边这个
            return leftRes;
        }
    }
}