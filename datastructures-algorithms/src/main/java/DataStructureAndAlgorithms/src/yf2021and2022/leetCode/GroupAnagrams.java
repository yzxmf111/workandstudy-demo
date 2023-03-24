package January.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/18 16:54
 */


public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        //巧用hash
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) return list;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s, temp);
            } else {
                map.get(s).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
