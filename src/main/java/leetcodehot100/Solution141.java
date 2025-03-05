package leetcodehot100;

import entity.ListNode;

import java.util.HashSet;

/*
给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
 */
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