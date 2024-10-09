package leetcodehot100;

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
//思路就是：
// 把第一行第一列是否有0找两个字段标记，遍历数组，找到有0的，把他的第一行第一列标记成0，说明我们这一列/行需要标记成0，
// 然后遍历完之后再遍历一边，
// 判断条件就是他的第一行第一列是否是0，然后再对第一行第一列处理
class Solution73 {
    public void setZeroes(int[][] matrix) {
        // 用于记录行列长度
        int m = matrix.length;
        int n = matrix[0].length;
        // 用来记录第一列和第一行是否有0
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果有0的话，先把第一行和第一列都置为0，然后再判断是否是第一列或者第一行
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                    // 然后判断是否是第一列或者第一行
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        colZero = true;
                    }
                }
            }
        }
        // 之后除了第一行和第一列都进行置零操作
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 然后单独处理第一行和第一列 第一行和第一列进行置零操作
        for (int i = 0; colZero && i < m; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; rowZero && i < n; i++) {
            matrix[0][i] = 0;
        }
    }
}