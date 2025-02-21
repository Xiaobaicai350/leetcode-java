package leetcodehot100;

/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true
 */
class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 进行遍历，得到直到得到最终的结果，如果dfs有一个返回的是true，说明这个数组里面就有word
                boolean dfs = dfs(board, word, i, j, 0);
                if (dfs) {
                    // 只要有一个dfs返回是true，就返回就好了
                    return true;
                }
            }
        }
        // 如果遍历完了还没有，说明这个数组里面没有word
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 首先进行边界判断，判断i，j是否合法，访问的这个格子是否在board范围内
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            // 如果有一个不满足说明就不在格子里面，直接返回false，说明这个格子不可以作为结果。
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            // 如果访问的这个格子的值不等于我们要访问的这个字母，也返回false
            return false;
        }
        // 如果走到这里了，说明这个是我们要找的第k位字母
        // 但是我们要判断一下这个字母是不是我们最终要找的字母的最后一位
        if (k == word.length() - 1) {
            return true;
        }
        // 为了防止他被多次访问，我们给他个特殊值，不过不用担心之后数据被破坏，如果后面步骤找不到合适的，会回滚
        board[i][j] = '$';
        // 将我们要找的字母位数加一
        k++;
        // 上、左、下、右
        boolean res = dfs(board, word, i, j - 1, k)
                || dfs(board, word, i - 1, j, k)
                || dfs(board, word, i, j + 1, k)
                || dfs(board, word, i + 1, j, k);
        // 回滚
        board[i][j] = word.charAt(k - 1);
        // 如果res为true，说明可以找到
        return res;
    }
}
