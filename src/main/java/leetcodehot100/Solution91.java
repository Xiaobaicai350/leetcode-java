package leetcodehot100;

/*
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 */


/*
当前位若不为 0，一定可以独立编码，所以 dp[i] = dp[i - 1]。
然后再去考虑能不能后两位联合编码，后两位联合编码要满足两个条件：1.前一位不为字符 '0'; 2.这两位构成的数小于等于 26 。如果这两个条件都满足，就在原来的基础加上联合编码的种类 dp[i] += dp[i - 2]。
等等！还要考虑越界的问题，也就是 i = 1 时怎么办 ？很简单，就是在前面的基础上加一，这个一指的就是后两位联合编码。
 */
class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        //dp[i]表示前i个字符的解码方法数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (chars[i] != '0') {
                dp[i] = dp[i - 1];
            }
            if (chars[i - 1] != '0' && (chars[i - 1] - '0') * 10 + chars[i] - '0' <= 26) {//满足前两位构成一个数的情况
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else {//对dp[1] 单独处理 ，因为他没有dp[i-2]的值
                    dp[i] += 1;
                }
            }
        }
        return dp[n - 1];
    }
}

