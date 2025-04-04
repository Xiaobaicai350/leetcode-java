package hardCode;

import java.util.LinkedList;

//实现一个简单的HashMap结构
class HashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //一共有三个成员变量
    //1、一个数组，这里用链表数组解决hash冲突
    //2、容量（初始化容量为11是因为11是一个质数。选择质数作为哈希表的初始容量可以减少哈希冲突的概率，从而提高哈希表的性能。质数在哈希函数中有助于更均匀地分布键值对，减少链表的长度。）
    //3、当前大小
    private LinkedList<HashNode<K, V>>[] chainArray;
    private final int M = 11; // 初始容量
    private int size;

    public HashTable() {
        chainArray = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chainArray[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(K key) {
        //注意这里计算hash的话，是用hashcode对容量取余，映射到数组上
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value) {
        int index = hash(key);
        //遍历链表的整条链
        for (int i = 0; i < chainArray[index].size(); i++) {
            HashNode<K, V> node = chainArray[index].get(i);
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        chainArray[index].add(new HashNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> chain = chainArray[index];
        for (int i = 0; i < chain.size(); i++) {
            HashNode<K, V> node = chain.get(i);
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }


    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> toRemove = null;
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }
        if (toRemove == null) return null;
        chainArray[index].remove(toRemove);
        size--;
        return toRemove.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


