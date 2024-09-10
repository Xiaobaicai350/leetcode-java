package writtenExamination.腾讯音乐笔试0905;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Objects;

public class Demo2 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param a ListNode类
         * @param b ListNode类
         * @return ListNode类
         */
        public ListNode mergeList(ListNode a, ListNode b) {
            ArrayList<Integer> ints1 = getV(a);
            ArrayList<Integer> ints2 = getV(b);
            int end = 0;
            for (int i = 0; i < ints1.size() && i < ints2.size(); i++) {
                if (!Objects.equals(ints1.get(i), ints2.get(i))) {
                    end = i;
                    break;
                }
            }
            int start = 0;
            for (int i = ints1.size() - 1, j = ints2.size() - 1; i > 0 && j > 0; i--, j--) {
                if (!Objects.equals(ints1.get(i), ints2.get(j))) {
                    start = i;
                    break;
                }
            }
            ListNode head = combineListNode(ints1, end, start);
            return head.next;
        }

        private ListNode combineListNode(ArrayList<Integer> ints1, int end, int start) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            System.out.println("end:" + end);
            System.out.println("start:" + start);

            for (int i = 0; i < ints1.size(); i++) {
                if (i > end - 1 && i <= start) {
                    continue;
                } else {
                    ListNode newNode = new ListNode(ints1.get(i));
                    cur.next = newNode;
                    cur = cur.next;
                }
            }
            return head;
        }

        private ArrayList<Integer> getV(ListNode a) {
            ListNode cur = a;
            ArrayList<Integer> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            return list;
        }
    }
}
