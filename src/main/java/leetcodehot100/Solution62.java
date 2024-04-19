package leetcodehot100;

//由于每一步只能从向下或者向右移动一步，所以想得到dp[i][j]的话，就是需要从dp[i-1][j]和dp[i][j-1]得到
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