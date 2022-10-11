package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/18 22:31
 */


public class TestTrie {

    private Node root;

    //路径记录着单词是否存在
    //类似于链表,不过每个节点连着的是一个map
    class Node {
        private Node[] dict;
        private boolean isWord;

        public Node() {
            this.dict = new Node[26];
            this.isWord = false;
        }
    }

    public TestTrie() {
        root = new Node();
    }

    public void insert(String word) {
        int len = word.length();
        Node curNode = root;
        //对单词的每一个字母进行处理
        for (int i = 0; i < len; i++) {
            Node next = curNode.dict[word.charAt(i) - 'a'];
            if (next == null) {
                next = new Node();
            }
            curNode = next;
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    public boolean search(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            Node next = curNode.dict[word.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            curNode = next;
        }
        return curNode.isWord;
    }

    public boolean startWith(String predix) {
        int len = predix.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            Node next = curNode.dict[predix.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            curNode = next;
        }
        return true;
    }

}
