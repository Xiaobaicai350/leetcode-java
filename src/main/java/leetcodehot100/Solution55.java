package leetcodehot100;

/**
 * 其实基本的思想就是不停的更新cover的最大值，就找最大的cover，如果不符合题意就直接返回了
 * cover的意思就是范围到数组的哪个下标的
 */
class Solution55 {
    public boolean canJump(int[] nums) {
        // cover表示从当前节点能走到最远的位置
        int cover = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果i比cover还大了，说明路径已经断了，走不到终点了
            if (i > cover) {
                return false;
            }
            // 更新cover值
            cover = Math.max(cover, i + nums[i]);
        }
        // 如果走到这里还没返回false，说明这个数组就是满足题意的
        return true;
    }
}
