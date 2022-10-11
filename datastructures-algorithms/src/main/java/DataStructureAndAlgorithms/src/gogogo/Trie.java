//package gogogo;
//
//public class Trie {
//
//    Node root;
//
//    class Node {
//        boolean isWord;
//        Node[] dict;
//
//        public Node() {
//            dict = new Node[26];
//        }
//    }
//
//    public Trie() {
//        root = new Node();
//    }
//
//    public void insert(String word) {
//        if (word == null || word.length() == 0) return;
//        Node curNode = root;
//        for (int i = 0; i < word.length(); i++) {
//            Node next = curNode.dict[word.charAt(i) - 'a'];
//            System.out.println("111" + next);
//            if (next == null) {
//                curNode.dict[word.charAt(i) - 'a'] = new Node();
//                //不可使用下边的创建新的节点的原因：每次创建的节点的内存地址并不存在root的数组中，这样就不是前缀树了
//                //  next = new Node();
//            }
//            System.out.println(next + "");
//            //进入下一层
////                curNode =  next;
//            curNode = curNode.dict[word.charAt(i) - 'a'];
//        }
//        if (!curNode.isWord) {
//            curNode.isWord = true;
//        }
//    }
//
//    public boolean search(String word) {
//        Node curNode = root;
//        for (int i = 0; i < word.length(); i++) {
//            Node next = curNode.dict[word.charAt(i) - 'a'];
//            if (next == null) {
//                return false;
//            }
//            curNode = next;
//        }
//        if (curNode.isWord) {
//            return true;
//        }
//        return false;
//
//    }
//
//    public boolean startsWith(String prefix) {
//        Node curNode = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            Node next = curNode.dict[prefix.charAt(i) - 'a'];
//            if (next == null) {
//                return false;
//            }
//            curNode = next;
//        }
//        return true;
//
//    }
//
//
//
//    /* Your Trie object will be instantiated and called as such:*/
//
//
//    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("word");
//        boolean param_2 = trie.search("word");
//        boolean param_3 = trie.startsWith("wod");
//    }
//}
///**
// * 前缀树
// */
////class Trie {
////
////    private Node root;
////
////    class Node {
////        private Node[] dict;
////        private boolean isWord;
////
////        public Node() {
////            this.dict = new Node[26];
////            this.isWord = false;
////        }
////    }
////
////    /**
////     * Initialize your data structure here.
////     */
////    public Trie() {
////        this.root = new Node();
////    }
////
////    /**
////     * Inserts a word into the trie.
////     */
////    public void insert(String word) {
////        int len = word.length();
////        Node curNode = root;
////        for (int i = 0; i < word.length(); i++) {
////            Node next = curNode.dict[word.charAt(i) - 'a'];
////            if (next == null) {
////                //next = new Node();其错误在于next现在并没有地址值,没有指向curNode.dict[word.charAt(i) - 'a']在内存中的地址
////                //这样就不是前缀树了
////                curNode.dict[word.charAt(i) - 'a'] = new Node();
////
////            }
////            System.out.println(next);
////            curNode = curNode.dict[word.charAt(i) - 'a'];
////        }
////        if (!curNode.isWord) {
////            //Trie 字典树/前缀树 携带的仅仅只是isword, search的时候判断该单词是否存在
////            curNode.isWord = true;
////        }
////    }
////
////    /**
////     * Returns if the word is in the trie.
////     */
////    public boolean search(String word) {
////        int len = word.length();
////        Node curNode = root;
////        for (int i = 0; i < word.length(); i++) {
////            Node next = curNode.dict[word.charAt(i) - 'a'];
////            if (next == null) {
////                return false;
////            }
////            curNode = next;
////        }
////        return curNode.isWord;
////    }
////
////    /**
////     * Returns if there is any word in the trie that starts with the given prefix.
////     */
////    public boolean startsWith(String prefix) {
////        int len = prefix.length();
////        Node curNode = root;
////        for (int i = 0; i < prefix.length(); i++) {
////            Node next = curNode.dict[prefix.charAt(i) - 'a'];
////            if (next == null) {
////                return false;
////            } else {
////                curNode = next;
////            }
////        }
////        return true;
////    }
////}
