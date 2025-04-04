package leetcodehot100;


import entity.TreeNode;

/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
（高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。）
示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //安全性校验
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        //选择中间的作为根节点
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //传入左半部分
        root.left = buildBST(nums, start, mid - 1);
        //传入右半部分
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }

}
