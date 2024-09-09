package leetcodehot100;

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0; // 定义最大正方形边长变量，初始值为0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide; // 如果矩阵为空或没有元素，返回0
        }
        int rows = matrix.length; // 矩阵的行数
        int columns = matrix[0].length; // 矩阵的列数
        for (int i = 0; i < rows; i++) { // 遍历矩阵的行
            for (int j = 0; j < columns; j++) { // 遍历矩阵的列
                if (matrix[i][j] == '1') { // 如果当前元素是1
                    maxSide = Math.max(maxSide, 1); // 更新最大边长（至少是1x1的正方形）
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) { // 尝试增加正方形的边长
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true; // 标记是否新增的行和列都是1
                        if (matrix[i + k][j + k] == '0') {
                            break; // 如果对角线元素是0，则不可能形成更大的正方形，跳出循环
                        }
                        for (int m = 0; m < k; m++) { // 遍历新增的行和列
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false; // 如果发现0，标记为false
                                break; // 跳出循环
                            }
                        }
                        if (flag) { // 如果新增的行和列都是1
                            maxSide = Math.max(maxSide, k + 1); // 更新最大边长
                        } else {
                            break; // 如果不是，则不可能形成更大的正方形，跳出循环
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide; // 计算最大正方形的面积
        return maxSquare; // 返回最大正方形的面积
    }
}
