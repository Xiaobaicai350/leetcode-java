package leetcodehot100;

import entity.TreeNode;

/*
给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。

示例 1：
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [0]
输出：[0]
 */
/**
 * 题目中给了两个条件：
 * 1.展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 2.展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 这是一个固定的转移顺序，是有规律的，具体可以模拟一下
 * https://www.bilibili.com/video/BV14s4y1U77K/?spm_id_from=333.337.search-card.all.click&vd_source=2259e5459a8cfd21bcf92bc46bf3beda
 */
class Solution114 {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            //如果左子树为null，就直接遍历下一个右子树
            if (node.left == null) {
                node = node.right;
            } else {//到这里说明左子树不为空，需要开始迁移了，
                //迁移的规则是由上面两个条件决定的，比如决定了形状是一个单链表，并且遍历顺序跟先序遍历是一样的。
                //然后其实就是把node的右节点接到左子树的右树最后面了，然后把node左右换位置就行了。


                //保存左子树的地址
                TreeNode temp = node.left;
                //找到左子树的最后一个右子树
                while (temp.right != null) {
                    temp = temp.right;
                }
                //将最后一个右子树的右子树保存为node的右子树
                temp.right = node.right;
                //将node的左子树移动到node的右子树上
                node.right = node.left;
                //将左子树制空
                node.left = null;
                //继续向下遍历
                node = node.right;
            }
        }
    }
}