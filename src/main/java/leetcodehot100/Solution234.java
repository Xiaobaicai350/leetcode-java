package leetcodehot100;

import entity.ListNode;

import java.util.ArrayList;

/*
输入：head = [1,2,2,1]
输出：true
 */

/**
 * 这道题的方法就是把链表中的数据都存储到集合中，就好验证拉
 * （注意，因为不知道这个链表有多大，所以用集合，因为集合可以动态扩缩容）
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        // 把元素都加入到集合中，方便验证回文
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        //利用双指针进行验证
        //直接用i和j指向数组的最左边和最右边，然后开始验证
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                // 如果不相等，说明不回文,直接返回false
                return false;
            }
        }
        // 到这里说明都相等，说明是回文子串
        return true;
    }
}