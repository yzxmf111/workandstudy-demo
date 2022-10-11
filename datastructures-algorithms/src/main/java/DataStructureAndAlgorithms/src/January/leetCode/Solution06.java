package January.leetCode;

import java.util.*;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/26 22:31
 */


public class Solution06 {

    public static void main(String[] args) {
        Solution06 s = new Solution06();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = s.groupAnagrams(str);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) return list;
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            //String s = chars.toString();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s,temp);
            } else {
                map.get(s).add(strs[i]);

            }
        }

        return new ArrayList<>( map.values());


    }
}
