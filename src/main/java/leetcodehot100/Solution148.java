package leetcodehot100;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution148 {
    /**
     * 本方法是先把链表添加到集合中，再通过Collections.sort进行排序，之后再转换回链表就可以了。
     */
    public ListNode sortList1(ListNode head) {
        // 将链表元素存储在集合中
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 对集合进行排序
        Collections.sort(list);

        // 将排序后的集合转换为链表
        ListNode dummy = new ListNode(0);
        cur = dummy;
        for (int value : list) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * 归并排序的方法
     * 效率要比上面那个方法高一些
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 处理特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        // 找到中间位置，定义快慢指针
        ListNode left = head;
        ListNode right = head.next;
        while (right != null && right.next != null) {
            // 慢指针走一步
            left = left.next;
            // 快指针走两步
            right = right.next.next;
        }

        // 当执行到这里时，left指向中间位置
        // 记录后半部分的指针
        ListNode mid = left.next;
        // 断开前半部分和后半部分的连接
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