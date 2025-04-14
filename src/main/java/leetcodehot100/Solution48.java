package leetcodehot100;

/*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

1 2 3
4 5 6
7 8 9

翻转后
7 4 1
8 5 2
9 6 3
 */

//其实这道题的关键就是找到规律
// 先沿主对角线翻转，再沿竖直中线翻转
class Solution48 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;

        // 沿主对角线翻转
        for (int i = 0; i < row; i++) {//所以这一步之需要遍历下半部分就可以了
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 沿竖直中线翻转
        for (int i = 0; i < row; i++) {//这只用遍历左半边，右半边row-j-1就可以了
            for (int j = 0; j < row / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - j - 1];
                matrix[i][row - j - 1] = temp;
            }
        }
    }
}