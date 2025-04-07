package leetcodehot100;

import entity.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 用手画一下逻辑就好了
 * 1-》2-》3-》4
 * 2-》1-》4-》3
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头结点
        ListNode dummy = new ListNode();
        // 给dummy赋初值
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;// 保存的是一的引用
            ListNode temp2 = cur.next.next.next;// 保存的是三的引用
            cur.next = cur.next.next;// 1
            cur.next.next = temp1;// 2
            cur.next.next.next = temp2;// 3
            cur = cur.next.next;// cur移动两位，准备下一轮交换
        }
        return dummy.next;
    }
}