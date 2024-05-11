package leetcodehot100;

//思路：
//		数组中的每个元素num指向下一个元素nums[num]
//		如果有重复数字，肯定存在一个环形链表
//		环入口节点的前一个节点即为重复的元素
/*
输入：nums = [1,3,4,2,2]
输出：2
 */
class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        //slow走一步，fast走两步，直到slow==fast，这时就可以让slow置零了
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}