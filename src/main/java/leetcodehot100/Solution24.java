package leetcodehot100;

import entity.ListNode;

/**
 * 用手画一下逻辑就好了
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头结点
        ListNode dummy = new ListNode(0);
        // 给dummy赋初值
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;// 保存的是一的引用
            ListNode temp2 = cur.next.next.next;// 保存的是三的引用
            cur.next = cur.next.next;// 1
            cur.next.next = temp1;// 2
            cur.next.next.next = temp2;// 3
            cur = cur.next.next;//// cur移动两位，准备下一轮交换
        }
        return dummy.next;
    }
}