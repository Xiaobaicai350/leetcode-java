package leetcodehot100;

//思路：
//		数组中的每个元素num指向下一个元素nums[num]
//		如果有重复数字，肯定存在一个环形链表
//		环入口节点的前一个节点即为重复的元素
class Solution287 {
    public int findDuplicate(int[] nums) {
        // 快指针，每次移动两步
        int fast = nums[0];
        // 慢指针，每次移动一步
        int slow = nums[0];
        // 快指针移动两步
        fast = nums[nums[fast]];
        // 慢指针移动一步
        slow = nums[slow];
        // 当快慢指针没有相遇时，继续移动
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        // 重置快指针到起点
        fast = nums[0];
        // 快慢指针都每次移动一步，直到它们相遇
        // 相遇点即为环的入口，也就是重复的数字
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        // 返回重复的数字
        return slow;
    }
}