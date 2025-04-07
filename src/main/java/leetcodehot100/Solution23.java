package leetcodehot100;

import entity.ListNode;

/**
 * 这道题的核心思想就是先把k个升序链表进行合并，然后在进行排序就可以了。
 * 具体的排序思路可以参照题148，有两种方法，一种是集合，一种是归并排序
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        //链接k个升序链表
        for (int i = 0; i < lists.length; i++) {
            cur.next = lists[i];
            while (cur.next != null) {
                cur = cur.next;
            }
            //现在cur在一条链表的末尾节点位置
        }
        //注意这里传的是dummy.next 因为dummy这个节点不用排序
        return sortLists(dummy.next);
    }

    private ListNode sortLists(ListNode node) {
        //1.递归出口
        if (node == null || node.next == null) {
            //到这里说吗没必要排序了
            return node;
        }
        //2.走到中间，把这条链表分成 头-》中间     中间-》尾巴 两条链表
        //不在同一起跑线是为了在链表长度为偶数时，更方便地将链表从中间断开。
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //现在slow在中间
        //断开连接
        ListNode mid = slow.next;
        slow.next = null;
        //返回的是左/右表排序好的头节点
        ListNode l = sortLists(node);
        ListNode r = sortLists(mid);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val > r.val) {
                cur.next = r;
                r = r.next;
                cur = cur.next;
            } else {
                cur.next = l;
                l = l.next;
                cur = cur.next;
            }
        }
        // 处理剩余节点
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummy.next;
    }
}