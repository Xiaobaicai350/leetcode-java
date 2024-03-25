package leetcodehot100;

import haohao.ListNode;

/**
 * 这道题就是模拟十进制进位，然后需要注意的是那里/10 %10的操作
 */
class Solution2 {
    // 不能用这种方法，因为这种方法会受限于int和long的数据类型的长度，并且只能跑过99%的测试用例。。。。
    public ListNode errAddTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null) {
            return new ListNode(0);
        }
        long l1Value = 0;
        long l2Value = 0;
        // 位数
        int count = 0;
        while (l1 != null) {
            l1Value += l1.val * Math.pow(10, count);
            l1 = l1.next;
            count++;
        }
        count = 0;
        while (l2 != null) {
            l2Value += l2.val * Math.pow(10, count);
            l2 = l2.next;
            count++;
        }
        // 得到结果
        long res = l1Value + l2Value;
        // 转换成链表形式
        ListNode resHead = new ListNode(0);
        ListNode cur = resHead;
        while (res != 0) {
            long val = res % 10;
            res /= 10;
            ListNode nextNode = new ListNode((int) val);
            cur.next = nextNode;
            cur = cur.next;
        }
        return resHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这种方法其实就是模拟了加法进位，然后不用考虑会超过int和long，
        // 因为两个个位数相加不可能大于20，相对于超过int还远呢

        // 新建虚拟头结点，用于新建返回链表
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        // 用来保存进位信息
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        return dummyNode.next;
    }
}