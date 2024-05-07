package leetcodehot100;

// [1,2,3,4]
// left ：[1,1,2,6]
// right: [24,12,4,1]
// ans  : [24,12,8,6]

/**
 * 这道题要注意好边界的问题，和怎么对左数组赋值和如何给右数组赋值的就好了
 */
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 计算出数组长度
        int n = nums.length;
        // left用来存储除i以外的左边数组之积
        int[] left = new int[n];
        // right用来存储除i之外的右边数组之积
        int[] right = new int[n];
        // ans用来存储i的左右数组之积
        int[] ans = new int[n];
        // 初始化左数组
        left[0] = 1;
        // 初始化右数组
        right[n - 1] = 1;
        // 从左往右 给左数组赋值
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // 从右往左 给右数组赋值
        for (int i = n - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        // 结果集等于相应的左数组乘相应的右数组
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
