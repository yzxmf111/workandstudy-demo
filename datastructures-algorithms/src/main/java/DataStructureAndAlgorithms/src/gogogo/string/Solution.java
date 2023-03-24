package DataStructureAndAlgorithms.src.gogogo.string;

import java.util.*;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-15 20:14
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
            ans[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) return false;
        }
        return true;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        //String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //List<List<String>> lists = new Solution().groupAnagrams(s);
        //System.out.println(lists);



    }
}
