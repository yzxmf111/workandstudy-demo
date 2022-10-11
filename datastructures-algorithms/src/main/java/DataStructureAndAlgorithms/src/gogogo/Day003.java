package DataStructureAndAlgorithms.src.gogogo;

public class Day003 {

    public char findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for (char c: s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            if (--counter[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char theDifference = new Day003().findTheDifference("aaaa", "aaaaa");

    }
}
