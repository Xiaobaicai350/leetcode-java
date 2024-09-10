package leetcodehot100;

import entity.ListNode;

/**
 * didi二面原题
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 用快慢指针
        // 首先定义虚拟节点,使用虚拟节点的原因是因为需要特殊考虑头指针是被删除的情况
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 先让fast走n+1步，这样fast为null的时候slow刚好为删除节点前面的位置
        for (int i = 0; i <= n && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 现在slow为删除节点的前一个位置了
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}