package leetcodehot100;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int size;//缓存目前的大小（存储了多少）
    private int capacity;//容量（可以存储多少）
    private Map<Integer, DLinkedNode> cache;//缓存真正存储的地方
    private DLinkedNode head, tail;//双向链表

    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    /**
     * 初始化双向链表
     * @param key 该双向链表的key
     * @param value 该双向链表的value
     * @return
     */
    private DLinkedNode initDLinkedNode(int key, int value) {
        DLinkedNode node = new DLinkedNode();
        node.key = key;
        node.value = value;
        return node;
    }

    /**
     * 初始化缓存的构造方法
     * @param capacity 容量大小
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = initDLinkedNode(0, 0);
        this.tail = initDLinkedNode(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * 从缓存中get值的方法
     * @param key
     * @return
     */
    public int get(int key) {
        //从缓存中获取
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //因为是lru，所以每次访问都会把当前节点放到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 把数据放入缓存的方法
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //先检验有没有
        DLinkedNode node = cache.get(key);
        if (node == null) {//如果没有的话
            //就新建一个双向链表的节点，这个相当于new
            node = initDLinkedNode(key, value);
            //然后把数据放入缓存中
            cache.put(key, node);
            //添加到头，这个跟移动到头不一样
            addToHead(node);
            //并且把在缓存中的数据加一
            size++;
            if (size > capacity) {//如果存储量大于容量了，就触发删除机制，从链表尾部删除
                DLinkedNode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        } else {//如果已经存在于缓存，这次就相当于更新
            //一共需要两个操作，一个是更新，一个是把这个节点移动到头部，因为是lru
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 把这个节点添加到头节点的位置
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 从双向链表中把这个节点删除
     * @param node 要删除的节点
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 把这个节点转移到头节点的位置
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 把这个节点从双向链表中删除
     * @return 删除的这个节点
     */
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
