package study2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description 自己实现一个简单的双向链表
 * @date 2023-02-14 17:33
 */
public class LRUCacheDemo {


    //容量限制
    private Integer size;
    private Integer capacity;
    //使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，
    //这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
    private Node head;
    private Node tail;
    private final Map<Integer, Node> cache = new HashMap<>();

    public LRUCacheDemo(int capacity) {
        this.capacity = capacity;
        size = 0;
        //伪头部
        head = new Node();
        //伪尾部
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveCurNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            //新增节点，如果达到容量的话，链表最老的节点，cache也要删除
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                int deleteKey = deleteTailNode();
                cache.remove(deleteKey);
                --size;
            }
        } else {
            node.value = value;
            moveCurNodeToHead(node);
        }
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }

    private int deleteTailNode() {
        Node preTail = tail.pre;
        deleteCurNode(preTail);
        return preTail.key;
    }

    private void moveCurNodeToHead(Node node) {
        deleteCurNode(node);
        addToHead(node);
    }

    private void deleteCurNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void moveToHead(Node node) {

    }


    public static void main(String[] args) {
        LRUCacheDemo lRUCache = new LRUCacheDemo(1);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);    // 返回 1
        lRUCache.get(1);    // 返回 1
        //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        //lRUCache.get(2);    // 返回 -1 (未找到)
        //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        //lRUCache.get(1);    // 返回 -1 (未找到)
        //lRUCache.get(3);    // 返回 3
        //lRUCache.get(4);    // 返回 4
    }

}
