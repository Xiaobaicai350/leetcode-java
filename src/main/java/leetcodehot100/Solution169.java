package leetcodehot100;

/**
 *    这道题是经典的摩尔投票法
 */
public class Solution169 {
    // 摩尔投票法只能找出来多于半数的那个候选者，本题也刚好是找到那个人
    public int majorityElement(int[] nums) {
        // 标识候选者是哪个数字
        int candidate = 0;
        // 候选者的票数
        int candidateVotes = 0;
        // 遍历投票数组
        for (int i = 0; i < nums.length; i++) {
            // 进行校验，如果当前的候选者等于0了，就需要换候选者了
            if (candidateVotes == 0) {
                candidate = nums[i];
            }
            // 之后在进行判断这个数组这个元素是否支持这个候选者
            if (nums[i] == candidate) {
                candidateVotes++;
            } else { // 如果不支持的话，就把支持者的票数--
                candidateVotes--;
            }
        }
        // 如果这个候选者大于1/2,candidate就是他
        return candidate;
    }
}
