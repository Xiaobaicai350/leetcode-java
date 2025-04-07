package leetcodehot100;

import entity.ListNode;

/**
 * 这道题的核心思想就是先把k个升序链表进行合并，然后在进行排序就可以了。
 * 具体的排序思路可以参照题148，有两种方法，一种是集合，一种是归并排序
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        //用于连接链表
        ListNode cur = dummy;

        // 先将k条链表合并为一条链表
        for (int i = 0; i < lists.length; i++) {
            //将cur去连接每一个链表
            cur.next = lists[i];
            //遍历到链表的尾节点
            while (cur.next != null) {
                cur = cur.next;
            }
        }

        // 对链表进行排序
        return sortList(dummy.next);
    }

    //1.退出条件 head == null || head.next == null
    //2.定义快慢指针，找到中间位置
    //3.递归，返回头-》中间 中间-〉尾的有序链表
    //4.合并左右两个有序链表
    private ListNode sortList(ListNode head) {
        // 处理特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        // 找到中间位置，定义快慢指针
        ListNode left = head;
        ListNode right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }

        // 当执行到这里时，left指向中间位置
        ListNode mid = left.next;
        left.next = null;

        // 递归，注意返回的是排序后的头节点
        ListNode l = sortList(head);
        ListNode r = sortList(mid);

        // 合并左右两个有序链表
        ListNode res = new ListNode(0);
        ListNode ans = res;
        while (l != null && r != null) {
            if (l.val < r.val) {
                res.next = l;
                l = l.next;
            } else {
                res.next = r;
                r = r.next;
            }
            res = res.next;
        }

        if (l == null) {
            res.next = r;
        } else {
            res.next = l;
        }

        return ans.next;
    }
}