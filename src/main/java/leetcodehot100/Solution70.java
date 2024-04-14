package leetcodehot100;

class Solution70 {
    public int climbStairs(int n) {
        //如果n为1，说明只有一种方法
        if (n == 1) {
            return 1;
        }
        //创建dp数组
        //dp[i]的含义是：当楼梯层数为i时，有dp[i]种方法爬上去
        int[] dp = new int[n + 1];
        //初始化数组
        dp[1] = 1;//意思是当楼梯层数为1的时候，有1种方法爬上去
        dp[2] = 2;//意思是当楼梯层数为2的时候，有2中方法爬上去   因为可以爬两次1层，或者直接爬2层
        for (int i = 3; i <= n; i++) {
            //递推公式就是前面两个dp的相加
            //就是当要计算dp[i]的时候，dp[i-1]只需要爬一层，dp[i-2]需要爬两层
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //根据dp数组的含义，直接返回
        return dp[n];
    }
}