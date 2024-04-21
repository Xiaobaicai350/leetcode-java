package leetcodehot100;

//还是不会写
class Solution72 {
    public int minDistance(String word1, String word2) {
        // 定义两个字符串的长度
        int n = word1.length();
        int m = word2.length();

        // 检查是否有任意一个字符串为空串，如果是，则编辑距离为另一个字符串的长度
        if (n * m == 0) {
            return n + m;
        }

        // 初始化 dp 数组，其中 dp[i][j] 表示 word1[0...i-1] 和 word2[0...j-1] 的编辑距离
        int[][] dp = new int[n + 1][m + 1];

        // 初始化边界状态，dp[i][0] 和 dp[0][j] 分别表示 word1 和 word2 分别变为空串的编辑距离
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        // 使用动态规划填充 dp 数组
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 计算三个可能的编辑操作：左移（删除 word1[i-1]）、下移（删除 word2[j-1]）和左下移（替换 word1[i-1] 和 word2[j-1]）
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                // 取这三个编辑操作中的最小值作为当前状态的编辑距离
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        // 返回 dp 数组的最后一个值，即 word1 和 word2 的编辑距离
        return dp[n][m];
    }

}
