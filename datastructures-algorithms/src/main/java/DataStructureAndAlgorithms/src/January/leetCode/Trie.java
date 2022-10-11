package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/19 15:45
 */


public class Trie {

    private Node root;

    class Node {
        private Node[] dict;
        private boolean isWord;

        public Node() {
            this.dict = new Node[26];
            this.isWord = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node next = curNode.dict[word.charAt(i) - 'a'];
            if (next == null) {
                //next = new Node();其错误在于next现在并没有地址值,没有指向curNode.dict[word.charAt(i) - 'a']在内存中的地址
                //这样就不是前缀树了
                curNode.dict[word.charAt(i) - 'a'] = new Node();

            }
            System.out.println(next);
            curNode = curNode.dict[word.charAt(i) - 'a'];
        }
        if (!curNode.isWord) {
            //Trie 字典树/前缀树 携带的仅仅只是isword, search的时候判断该单词是否存在
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node next = curNode.dict[word.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            curNode = next;
        }
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Node next = curNode.dict[prefix.charAt(i) - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.toString());
        boolean b1 = trie.search("apple");
        boolean b2 = trie.startsWith("app");
        System.out.println(b1 + " " + b2);
    }
}
