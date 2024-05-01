package study2024;

import gogogo.ListNode;

import java.util.*;

/**
 * @author xiaotian
 * @description 字符串去重并且保持顺序
 * @date 2024-04-20 19:51
 */
public class D240430 {

    public String removeDup(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            if (map.get(chars[i]) > 1) {
                continue;
            } else {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abbcddae";
        D240430 d240430 = new D240430();
        String res = d240430.removeDup(s);
        System.out.println(res);

        int[] nums = {100,4,200,1,3,2};
        int i = d240430.longestConsecutive(nums);
        System.out.println(i);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> subList = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            subList.add(str);
            map.put(String.valueOf(chars), subList);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        int subMax = 0, max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            //对于不连续的数字来说，内外层的循环只有一次。对于连续的数字只有目前的数字是当最小的，才会进入内循环，o(n)
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num)) {
                subMax++;
                num++;
            }
            max = Math.max(subMax, max);
            subMax = 0;
        }
        return max;
    }

    public ListNode mergeKLists(ListNode[] lists) {

    }
}
