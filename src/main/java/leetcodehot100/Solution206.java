package leetcodehot100;

import entity.ListNode;

/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

示例 2：
输入：head = [1,2]
输出：[2,1]

示例 3：
输入：head = []
输出：[]
 */
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