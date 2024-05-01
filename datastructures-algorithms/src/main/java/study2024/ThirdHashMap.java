package study2024;



/**
 * @author xiaotian
 * @description 手写HashMap
 * @date 2024-03-17 20:54
 */
public class ThirdHashMap<K, V> {

    class Node<K, V> {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //基本属性
    private static final Integer DEFAULT_BINS_LENGTH = 1 << 4;
    private static final Double LOAD_FACTOR = 0.75d;
    private static int size;
    Node<K, V>[] table;

    public ThirdHashMap () {
        table  = new Node[DEFAULT_BINS_LENGTH];
    }

    public ThirdHashMap (int initialCapacity) {
        table  = new Node[initialCapacity];
    }



    public int getIndex(K key) {
        int h;
        //如果想简单，直接key.hashCode() % table.length
        return (key == null ? 0 : (h = key.hashCode()) ^ h >>> 16) & (table.length - 1);
    }


    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
        putVal(key, value, table);
    }

    private void putVal(K key, V value, Node<K, V>[] table) {
        int index = getIndex(key);
        Node<K, V> oldNode = table[index];
        Node<K, V> photoNode = oldNode;
        if (oldNode == null) {
            table[index] = new Node<>(key, value);
            size++;
            return;
        } else {
            //发生冲突，链地址发解决
            while (oldNode != null) {
                //这里为何这么写：hashcode 不同，equals一定不同，提前判断
                if (oldNode.key.hashCode() == key.hashCode()
                        && (oldNode.key == key || oldNode.key.equals(key))) {
                    oldNode.value = value;
                    return;
                }
                oldNode = oldNode.next;
            }
            //头插法
            table[index] = new Node<>(key, value, photoNode);
            size++;
        }

    }
    //
    //public Node<K, V> get(K key) {
    //    int index = getIndex(key);
    //    Node<K, V> node = table[index];
    //    if (node == null) {
    //        return null;
    //    }
    //    while (node != null) {
    //        if (node.key.hashCode() == key.hashCode()
    //                && (node.key == key || node.key.equals(key))) {
    //            return node;
    //        }
    //        node = node.next;
    //    }
    //    return null;
    //
    //}

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.key.hashCode() == key.hashCode()
                    && (node.key == key || node.key.equals(key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void resize2() {
        Node<K, V>[] newTable = new Node[table.length * 2];
        table = newTable;
        for (Node<K, V> node : table) {
            while (node != null) {
                putVal(node.key, node.value, newTable);
                node = node.next;
            }
        }
    }

    public void resize() {
        Node<K, V>[] newTable = new Node[table.length * 2];
        for (Node<K, V> node : table) {
            if (node == null) {
                continue;
            }
            while (node != null) {
                putVal(node.key, node.value, newTable);
                node = node.next;
            }
        }
        table = newTable;
    }

    public int size() {
        return  size;
    }

    public static void main(String[] args) {
        ThirdHashMap map = new ThirdHashMap();
        map.put("111", 1);
        map.put("111", 1111);
        map.put("222", 2);
        map.put("333", 3);

        System.out.println(map.get("111"));    // Output: 1
        System.out.println(map.get("2222"));    // Output: 2
        System.out.println(map.get("444"));   // Output: null
    }

}
