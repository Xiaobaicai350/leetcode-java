package leetcodehot100;

import java.util.*;

/*
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
class Solution994 {
    public int orangesRotting(int[][] grid) {
        int good = 0; // 好橘子的数量
        Queue<int[]> bad = new LinkedList<>(); // 坏橘子的位置

        // 遍历所有橘子，计算 好橘子的数量 和 坏橘子的位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                    case 1: // 如果值是1说明是新鲜橘子，就给计数加一
                        good++;
                        break;
                    case 2: // 如果是2说明是腐烂的橘子，加入到队列中
                        bad.offer(new int[]{i, j});
                        break;
                }
            }
        }

        int cnt = 0; // 记录扩散了多少次，相当于结果集
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向

        // 使用 BFS 模拟橘子腐烂并扩散的过程
        while (!bad.isEmpty() && good > 0) {
            int size = bad.size();
            // 开始扩散（遍历所有坏橘子）
            for (int i = 0; i < size; i++) {
                int[] cur = bad.poll();
                // 往上下左右四个位置扩散
                for (int[] dir : directions) {
                    int newI = cur[0] + dir[0];
                    int newJ = cur[1] + dir[1];
                    // 判断新位置是否在区域内且是新鲜橘子
                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                        good--;
                        grid[newI][newJ] = 2;
                        bad.offer(new int[]{newI, newJ});
                    }
                }
            }
            // 本次扩散完成，扩散次数+1
            cnt++;
        }

        // 退出循环之后，判断好橘子数量，如果还大于0，说明不可能全部腐烂
        return good > 0 ? -1 : cnt;
    }
}
