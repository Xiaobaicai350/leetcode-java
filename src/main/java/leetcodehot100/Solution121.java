package leetcodehot100;

/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
class Solution121 {
    /**
     * 第二种方法，贪心
     * 在题目中，我们只要用一个变量记录一个历史最低价格 minprice，
     * 我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //也就是用两个变量来记录最低价和最大利润
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            //每次遍历都更新最低价
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            //也判断是否当前天数卖出是否可以是最高利润
            if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        //遍历完成后，maxprofit就是最大的
        return maxprofit;
    }
    /**
     * 第一种方法，采用动态规划的思想
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        //进行安全性校验
        if (prices.length < 2) {
            //长度为0或者1
            //为1只能当天买当天卖。利润为0
            //为0说明是空数组。利润为0
            return 0;
        }
        //具体思路是用一个dp数组来记录最大利润
        //dp[i]的含义是，在第i天卖出股票的最大利润是dp[i]
        int[] dp = new int[prices.length];
        //初始化dp数组
        dp[0] = 0;
        //初始化买入天的价格
        int buyDayPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //计算当天的利润
            int profit = prices[i] - buyDayPrice;
            dp[i] = Math.max(profit, dp[i - 1]);
            //更新买入的值
            buyDayPrice = Math.min(prices[i], buyDayPrice);
        }
        return dp[prices.length - 1];
    }
}
