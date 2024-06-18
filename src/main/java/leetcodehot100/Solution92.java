package leetcodehot100;

import haohao.ListNode;

/*
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode DummyNode = new ListNode();
        DummyNode.next = head;
        ListNode cur = DummyNode;
        int i = 0;
        while (i < left) {
            cur = cur.next;
            i++;
        }
        //现在
    }
}