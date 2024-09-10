package leetcodehot100;

import entity.ListNode;

/*
输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //新建虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        //如果下一个节点不为空，并且下下个节点不为空，就循环
        while (cur.next != null && cur.next.next != null) {
            //如果 下一个节点的值==下下个节点的值 ，就需要进行删除操作了
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                //保留最后一个不等于后面节点的值
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {//如果不等于，遍历下一个节点
                cur = cur.next;
            }
        }
        //返回头节点
        return dummy.next;
    }
}
