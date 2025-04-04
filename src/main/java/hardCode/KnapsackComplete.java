package hardCode;

//完全背包问题中，每种物品有无限个，你可以选择放入任意数量的物品。
public class KnapsackComplete {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        //设 dp[w] 表示容量为 w 的背包所能获得的最大价值
        int[] dp = new int[capacity + 1];

        /*
        对于每个物品 i，遍历所有可能的背包容量 w，当 w 大于等于 weights[i] 时，可以选择放入第 i 个物品。
        比较放入和不放入第 i 个物品的情况，取最大值更新 dp[w]。
        由于完全背包问题中每个物品可以无限次使用，所以这里是和 dp[w - weights[i]] 比较，而不是像 0 - 1 背包问题那样和 dp[i - 1][w - weights[i - 1]] 比较。
         */
        for (int i = 0; i < n; i++) {
            for (int w = weights[i]; w <= capacity; w++) {
                //比较放入和不放入的最大值
                //不放入第i个物品 dp[w]
                //  放入第i个物品 dp[w-weight[i]]+values[i]
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        System.out.println("完全背包问题的最大价值: " + knapsack(weights, values, capacity));
    }
}