package leetcodehot100;

import haohao.ListNode;

/**
 * 经典的翻转链表题
 * 比如遍历链表从左往右
 * pre为cur左边一个节点
 * temp用于交换地址
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
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