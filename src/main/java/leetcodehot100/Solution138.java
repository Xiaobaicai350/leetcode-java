package leetcodehot100;

import haohao.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 其实这道题主要的就是通过一个map用来存储当前节点和保存的新节点，之后看看逻辑就可以了
 */
public class Solution138 {
    public Node copyRandomList(Node head) {
        // 创建一个Map来保存原节点和复制节点的对应关系
        //key为当前节点的引用，value为新复制的这个节点
        Map<Node, Node> hashMap = new HashMap<>();

        // 用于遍历的节点
        Node cur = head;

        while (cur != null) {
            // 存储原节点和新节点的对应关系
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 将cur指向原链表的头部
        cur = head;

        // 给节点的对应关系赋值，如next和random，基于原链表的关系进行赋值
        while (cur != null) {
            // 获取新节点
            Node newNode = hashMap.get(cur);
            Node nextNode = hashMap.get(cur.next);
            Node randomNode = hashMap.get(cur.random);

            // 开始赋值
            newNode.next = nextNode;
            newNode.random = randomNode;

            // 向后遍历原链表
            cur = cur.next;
        }

        // 返回新链表的头节点
        return hashMap.get(head);
    }
}