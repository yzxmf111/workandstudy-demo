package gogogo;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-07 17:41
 */
public class TestTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("word");
        boolean word = trie.search("word");
        System.out.println(word);
    }
}
