package leetcodehot100;

/*
使用“快慢指针”技巧，这类似于在链表中寻找环的入口。
我们将数组视为一个循环链表，重复的数字即为环的入口。
我们可以设置两个指针，一个快一个慢，快指针一次移动两步，慢指针一次移动一步。由于存在重复的数字，所以快慢指针最终会在环内相遇。
然后我们可以将一个指针重新设置为数组的起始点，并让两个指针以相同的速度移动，它们将在环的入口，也就是重复的数字处相遇。
 */
/*
输入：nums = [1,3,4,2,2]
输出：2
nums[0] = 1，这意味着从 nums[0] 出发，下一个元素是 nums[1]。
nums[1] = 3，这意味着从 nums[1] 出发，下一个元素是 nums[3]。
nums[3] = 2，这意味着从 nums[3] 出发，下一个元素是 nums[2]。
nums[2] = 4，这意味着从 nums[2] 出发，下一个元素是 nums[4]。
nums[4] = 2，这意味着从 nums[4] 出发，下一个元素是 nums[2]。
 nums[0]->nums[1]->nums[3]->nums[2]->nums[4]
                                 |      |
                                 |------|
 */
class Solution287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
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