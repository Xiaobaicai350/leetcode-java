package leetcodehot100;

/*
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 */

class Solution72 {
    public int minDistance(String word1, String word2) {
        // 定义两个字符串的长度
        int n = word1.length();
        int m = word2.length();

        // 检查是否有任意一个字符串为空串，如果是，则编辑距离为另一个字符串的长度
        if (n * m == 0) {
            return n + m;
        }

        // 初始化 dp 数组，其中 dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最少操作次数。
        int[][] dp = new int[n + 1][m + 1];

        // 初始化边界状态，dp[i][0] 和 dp[0][j] 分别表示 word1 和 word2 分别变为空串的编辑距离
        //当 word2 为空字符串时，将 word1 转换为空字符串的操作次数就是删除 word1 的所有字符，即 dp[i][0] = i
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        //当 word1 为空字符串时，将 word2 转换为空字符串的操作次数就是插入 word2 的所有字符，即 dp[0][j] = j
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        // 使用动态规划填充 dp 数组
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 计算三个可能的编辑操作：
                // 1. 将 word1 的第 i 个字符删除，那么问题就转化为将 word1 的前 i - 1 个字符转换为 word2 的前 j 个字符，操作次数为 dp[i - 1][j] + 1。
                // 2. 在 word1 的前 i 个字符后面插入一个字符，使得 word1 的前 i + 1 个字符与 word2 的前 j 个字符匹配，操作次数为 dp[i][j - 1] + 1。
                // 3. 将 word1 的第 i 个字符替换为 word2 的第 j 个字符，使得 word1 的前 i 个字符与 word2 的前 j 个字符匹配，操作次数为 dp[i - 1][j - 1] + 1。
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                // 如果 word1 的第 i 个字符与 word2 的第 j 个字符不同，需要进行替换操作
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
