package leetcodehot100;

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
 */

//由于这个数组的特性，所以要从左下角开始遍历
class Solution240 {
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
