package hardCode;
//0 - 1 背包问题中，每种物品只有一个，你可以选择放入或不放入背包。
/*
weights 数组存储物品的重量，values 数组存储物品的价值，capacity 为背包的容量，dp[i][w] 表示前 i 个物品放入容量为 w 的背包中所能获得的最大价值。

对于第 i 个物品，有两种选择：
1.不放入背包：那么最大价值就是前 i - 1 个物品放入容量为 w 的背包的最大价值，即 dp[i - 1][w]。
2.放入背包：前提是当前背包的容量 w 要大于等于第 i 个物品的重量 weights[i - 1]。
    放入后，最大价值为第 i 个物品的价值 values[i - 1] 加上前 i - 1 个物品放入容量为 w - weights[i - 1] 的背包的最大价值，即 values[i - 1] + dp[i - 1][w - weights[i - 1]]。
 */
public class Knapsack01 {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {//当 weights[i - 1] <= w 时，说明可以选择放入第 i 个物品，此时比较放入和不放入的情况，取最大值更新 dp[i][w]。
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {//不能放入第 i 个物品，dp[i][w] 就等于 dp[i - 1][w]，即不放入第 i 个物品时的最大价值。
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        System.out.println("0 - 1 背包问题的最大价值: " + knapsack(weights, values, capacity));
    }
}