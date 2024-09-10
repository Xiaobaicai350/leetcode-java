package leetcodehot100;


import entity.TreeNode;


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
