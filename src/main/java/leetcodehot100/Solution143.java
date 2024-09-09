package leetcodehot100;

import haohao.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
class Solution143 {
    public void reorderList(ListNode head) {
        //安全性校验
        if (head == null) {
            return;
        }
        //新建list，用于存储链表中的数据
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        //把链表中的数据存储在list中
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        //新建两个指针，一个指向头部，一个指向尾部
        int i = 0, j = list.size() - 1;
        //按照规则重建链表
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}