package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/18 16:45
 */


public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        //1.hash解决
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (Integer i : hash) {
            if (i != 0) return false;
        }
        return true;
    }
}
