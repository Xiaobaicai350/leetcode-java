package leetcodehot100;

import haohao.ListNode;

import java.util.HashSet;

/**
 * 快手真题，当时就做的这个
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            // 如果set中已经有这个内存地址了，说明又回来了
            // 就说明有环了
            if (set.contains(cur)) {
                return true;
            } else {
                // 如果没有就说明这个不是，把这个添加到set中去
                set.add(cur);
            }
            cur = cur.next;
        }
        // 如果到这里说明出循环了，有环的话在循环里就返回了，现在说明没环了
        return false;
    }
}