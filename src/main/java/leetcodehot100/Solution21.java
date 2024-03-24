package leetcodehot100;

import haohao.ListNode;


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