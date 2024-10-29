package leetcodehot100;

/**
 * 其实这道题就是从左右分别开始遍历，然后移动短板，直到遍历所有的板，之后可以得到最大值
 */
/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
 */
class Solution11 {
    public int maxArea(int[] height) {
        // 初始化结果集
        int ans = 0;
        // 定义左指针
        int l = 0;
        // 定义右指针
        int r = height.length - 1;
        // 当左指针和右指针相遇的时候说明循环结束了
        while (l < r) {
            // 计算当前的容量，也就是通过得到最小的 高*底
            int newAns = Math.min(height[l], height[r]) * (r - l);
            // ans用于保存容量的最大值
            ans = Math.max(ans, newAns);
            // 移动短板，如果是左边的板比较短，就往右移动（为什么要移动短板呢？因为只有移动短板才有比现在结果更优的解）
            if (height[l] < height[r]) {
                l++;
            } else {
                // 如果是右边的板比较短，向左移动
                r--;
            }
        }
        return ans;
    }
}