package leetcodehot100;

import haohao.ListNode;

/**
 * 这道题用笔模拟一下过程就可以了
 * 需要注意的点有，先新建dummy，把后面的节点一视同仁。
 * 再创建start end startNext endNext指针 进行遍历和翻转
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            //记录下start的next和end的next
            ListNode startNext = start.next;
            ListNode endNext = end.next;
            //把end的next中断了，才可以传入reverse，要不然会把整个链表翻转
            end.next = null;
            //翻转以start.next为头的链表（这里end的next已经断开了）
            start.next = reverse(start.next);

            startNext.next = endNext;
            end = startNext;
            start = end;
        }

        return dummy.next;
    }

    //翻转以head为头的节点，返回翻转后的头结点
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}