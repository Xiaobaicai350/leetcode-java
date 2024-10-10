package leetcodehot100;

import entity.ListNode;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 新建链表的新头节点
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        ListNode a = list1;
        ListNode b = list2;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        // 到这里说明a遍历完了或者是b遍历完了
        if (a == null) {
            cur.next = b;
        } else {
            cur.next = a;
        }
        return newHead.next;
    }
}