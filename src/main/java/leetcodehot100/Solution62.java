package leetcodehot100;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

示例 1：
输入：m = 3, n = 7
输出：28

示例 2
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下

示例 3：
输入：m = 7, n = 3
输出：28
 */
//由于每一步只能从向下或者向右移动一步，所以想得到dp[i][j]的话，就是需要从dp[i-1][j]和dp[i][j-1]得到，因为跟这俩有关系，是只能向下或者向右移动一步
//所以状态转移方程就是            dp[i][j] = dp[i-1][j] + dp[i][j-1]

//这个其实跟杨辉三角很像。。。。
class Solution62 {
    public int uniquePaths(int m, int n) {
        //根据m创建dp数组
        //dp[i][j]的含义是：当位置为(i,j)时，有dp[i][j]条路径可以走到位置(i,j)
        int[][] dp = new int[m][n];
        //初始化第一行第一列都是1
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //从第一个位置开始给dp数组赋值，根据状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //向下或者向右 移动一步就可得到dp[i][j]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}