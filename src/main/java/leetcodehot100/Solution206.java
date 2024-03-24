package leetcodehot100;

import haohao.ListNode;

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;//设置cur为快指针
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;//保存原来的cur.next
            cur.next = pre;//翻转链表
            pre = cur;//更新cur和pre
            cur = temp;
        }
        return pre;
    }
}