package leetcodehot100;

/*
给你一个满足下述两条属性的 m x n 整数矩阵：
每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true

示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
 */
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 进行安全性校验
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 获取行高和列高
        int ls = matrix.length;
        int rs = matrix[0].length;
        // 初始化遍历二维数组的位置为左下角，这个位置是固定的，因为这个二维数组是有序的，可以进行简化
        int l = ls - 1;
        int r = 0;
        while (l >= 0 && r < rs) {
            if (matrix[l][r] > target) {
                // 如果当前值比目标值大，说明要往上找
                l--;
            } else if (matrix[l][r] < target) {
                // 如果当前值比目标值小，说明要往右边找
                r++;
            } else { // 说明当前值==目标值了，这时候就可以返回true了
                return true;
            }
        }
        // 如果到这里都找不到，说明这个二维数组里面没有target
        return false;
    }
}