package leetcodehot100;

import haohao.ListNode;

/**
 * 经典的翻转链表题
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;//设置cur为快指针
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            //pre和cur都往后走
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}