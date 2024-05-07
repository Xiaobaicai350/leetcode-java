package leetcodehot100;

import haohao.ListNode;

//其实基本思想就是:链表1的长度+链表2的长度=链表2的长度+链表1的长度。
//交换着走的时候就会碰面，这是一个很巧妙的方法
// 因为必然会有环了，所以才可以用这种方法
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //分别给AB一个指针，用于遍历链表
        ListNode a = headA;
        ListNode b = headB;
        //当a==b的时候会退出,因为我们找的就是a==b的情况
        while (!(a == b)) {
            //说明a走完第一个循环了，该走第二个循环了，也就是b的
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        //这里返回a和b都行，因为上面循环退出的时候a==b
        return a;
    }
}

