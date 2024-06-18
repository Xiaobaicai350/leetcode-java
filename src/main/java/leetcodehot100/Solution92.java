package leetcodehot100;

import haohao.ListNode;

/*
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //现在pre指向需要翻转的前一个节点
        //cur是要翻转的第一个节点
        ListNode cur = pre.next;
        ListNode next;
        //这里开始翻转链表
        for (; left < right; left++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}