package hardCode;

public class MapDemo {
    Node[] nodes;
    int cap;
    double loadFac = 0.75;
    int size;

    public MapDemo(int cap) {
        this.cap = cap;
    }

    public MapDemo() {
        this.cap = 16;
        this.size = 0;
        this.nodes = new Node[cap];
    }

    public void put(int key, int val) {
        int hash = hash(key);
        if (nodes[hash] == null) {
            nodes[hash] = new Node(key, val);
        } else {
            Node cur = nodes[hash];
            while (cur.next != null) {
                if (cur.key == key) {
                    //就是更新
                    cur.val = val;
                    return;
                }
                cur = cur.next;
            }
            cur.next = new Node(key, val);
        }
        size++;
        if ((double) size / cap > loadFac) {
            //进行扩容
            resize();
        }


//        if(){//判断是否进行树化
//
//        }
    }

    private void resize() {
        cap= cap * 2;
        Node[] newNodes = new Node[cap];
        for (Node node : nodes) {
            while (node != null) {
                int newHash = hash(node.key);
                //保存下一个节点：
                Node next = node.next;
                //头插法插入新的节点：
                node.next = newNodes[newHash];
                //更新新的头节点
                newNodes[newHash] = node;
                node = next;
            }
        }
        nodes = newNodes;
    }

    public Res get(int key) {
        Res res = new Res(0, false);
        int hash = hash(key);
        Node node = nodes[hash];
        if (node == null) {
            return res;
        } else {
            Node cur = node;
            while (cur != null) {
                if (cur.key == key) {
                    res.flag = true;
                    res.res = cur.val;
                    return res;
                }
                cur = cur.next;
            }
        }
        return res;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node prev = null;
        Node cur = nodes[hash];
        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    nodes[hash] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    public int hash(int key) {
        return key % cap;//这里用了简单的hash算法，也可以右移16位做一个扰动算法更加均匀
    }
}

class Res {
    int res;
    boolean flag;

    public Res(int res, boolean flag) {
        this.res = res;
        this.flag = flag;
    }
}

class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Main {
    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        mapDemo.put(1, 2);
        mapDemo.put(2, 3);
        mapDemo.put(11, 4);
        Res res = mapDemo.get(11);

        System.out.println(res.flag);
        System.out.println(res.res);
    }
}
