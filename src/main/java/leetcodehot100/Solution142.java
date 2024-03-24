package leetcodehot100;

import haohao.ListNode;

import java.util.HashSet;

/**
 * 和141一样，不同的是返回的节点不同
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            // 如果set中已经有这个内存地址了，说明又回来了
            // 就说明有环了
            if (set.contains(cur)) {
                return cur;
            } else {
                // 如果没有就说明这个不是，把这个添加到set中去
                set.add(cur);
            }
            cur = cur.next;
        }
        // 如果到这里说明出循环了，就没环了
        return null;
    }
}