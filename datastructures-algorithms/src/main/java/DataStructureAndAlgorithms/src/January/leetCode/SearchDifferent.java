package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/18 17:52
 */


public class SearchDifferent {

    public static void main(String[] args) {
        SearchDifferent searchDifferent = new SearchDifferent();
        char theDifference = searchDifferent.findTheDifference("abcd", "abced");
        System.out.println(theDifference);
    }

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

}
