package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
*/
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 行数
        int m = matrix.length;
        // 列数
        int n = matrix[0].length;
        // 定义上下左右边界
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        // 定义结果集
        List<Integer> ans = new ArrayList<>();
        while (true) {
            // 1.首先从左往右遍历
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }
            // 2.从上往下遍历
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            // 3.从右往左遍历
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }
            // 4.从下往上遍历
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return ans;
    }
}