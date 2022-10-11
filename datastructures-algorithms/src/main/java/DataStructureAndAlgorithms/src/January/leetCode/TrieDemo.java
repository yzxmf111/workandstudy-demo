package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/18 21:31
 */


public class TrieDemo {

    private Node root;

    private class Node {
        private Node[] dict;
        private boolean isWord;

        // 你可以假设所有的输入都是由小写字母 a-z 构成的。
        public Node() {
            dict = new Node[26];
            this.isWord = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public TrieDemo() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.dict[curChar - 'a'];
            if (next == null) {
                curNode.dict[curChar - 'a'] = new Node();
            }
            curNode = curNode.dict[curChar - 'a'];
        }
        if (!curNode.isWord) {
            //与搜索有关
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int len = word.length();
        Node curNode = root;

        for (int i = 0; i < len; i++) {
            char curC = word.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curC = prefix.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return true;
    }
}