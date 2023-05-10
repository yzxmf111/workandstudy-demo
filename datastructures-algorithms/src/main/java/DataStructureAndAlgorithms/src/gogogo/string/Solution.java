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


    public int lengthOfLongestSubstring(String s) {
        //1、双指针 2、dp？
        int i = 0, j = 0, max = 0;
        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            max = Math.max(max, i - j + 1);
            i++;
        }
        return max;

    }

    public static void main(String[] args) {
        //String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //List<List<String>> lists = new Solution().groupAnagrams(s);
        //System.out.println(lists);
        //Solution solution = new Solution();
        //solution.lengthOfLongestSubstring("abc")
        List<String> a = null;
        for (String s : a) {
            System.out.println("sd");
        }


    }
}
