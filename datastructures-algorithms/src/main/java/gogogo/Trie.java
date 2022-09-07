package gogogo;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-07 16:37
 */
public class Trie {

    Node root;

    class Node {
        boolean isWord;
        //自我嵌套
        Node[] dict;

        public Node(){
            dict = new Node[26];
        }
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Node curNdoe = root;

        for (int i = 0; i < word.length(); i++) {
            Node next = curNdoe.dict[word.charAt(i) - 'a'];
            if (next == null) {
                curNdoe.dict[word.charAt(i) - 'a'] = new Node();
                //不可使用下边的创建新的节点的原因：搜索搜不到
                //next = new Node();
            }
            curNdoe = curNdoe.dict[word.charAt(i) - 'a'];
        }
        curNdoe.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node next = curNode.dict[word.charAt(i) - 'a'];
            if (next != null) {
                curNode = next;
            } else {
                return false;
            }
        }
        if (curNode.isWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Node next = curNode.dict[prefix.charAt(i) - 'a'];
            if (next != null) {
                curNode = next;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
