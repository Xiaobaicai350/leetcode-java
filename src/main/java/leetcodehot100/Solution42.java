package leetcodehot100;

/**
 * 这道题其实就是找到左右的最大值，然后依次往中间进行遍历，ans的加是通过最大值-遍历节点的值得到的。
 */
class Solution42 {
    // trap 方法用于计算给定高度数组中可以接多少雨水
    public int trap(int[] height) {
        int l = 0;          // l 是左指针，初始指向数组的起始位置
        int r = height.length - 1; // r 是右指针，初始指向数组的最后一个元素
        int lMax = 0;       // lMax 记录从左到当前位置的最高柱子高度
        int rMax = 0;       // rMax 记录从右到当前位置的最高柱子高度
        int ans = 0;        // ans 用于累计接雨水的总量

        // 当左指针小于右指针时，进行循环
        while (l < r) {
            lMax = Math.max(lMax, height[l]); // 更新从左到当前位置的最高柱子高度
            rMax = Math.max(rMax, height[r]); // 更新从右到当前位置的最高柱子高度

            // 如果左边的最高柱子比右边的低，那么接雨水的量取决于左边的最高柱子
            if (lMax < rMax) {
                ans += lMax - height[l]; // 累加接雨水的量（左边最高柱子高度减去当前柱子高度）
                l++; // 左指针向右移动
            } else {
                ans += rMax - height[r]; // 如果右边的最高柱子更低，同理
                r--; // 右指针向左移动
            }
        }
        return ans; // 返回累计的接雨水量
    }
}
