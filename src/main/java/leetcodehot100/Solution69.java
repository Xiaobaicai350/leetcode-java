package leetcodehot100;

/*
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

示例 1：
输入：x = 4
输出：2

示例 2：
输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
//二分查找方法
class Solution69 {
    public long mySqrt(long x) {
        //其实就是在0-x之间找一个数的平方小于等于x，然后不停更新ans，找到最大的ans，最后返回
        long l = 0;
        long r = x;
        long ans = -1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            //这里必须转long，要不然会溢出
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}