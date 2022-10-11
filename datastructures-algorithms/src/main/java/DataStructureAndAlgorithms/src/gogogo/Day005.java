package gogogo;

import java.util.HashMap;
import java.util.Map;

public class Day005 {

    /**
     * 思路：双指针
     *我们使用两个指针，一个i一个j，最开始的时候i和j指向第一个元素，然后i往后移，
     * 把扫描过的元素都放到map中，如果i扫描过的元素没有重复的就一直往后移，顺便记录一下最大值max，
     * 如果i扫描过的元素有重复的，就改变j的位置，我们就以pwwkew为例画个图看一下
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();//解决重复的问题
        Integer max = 0;  //返回结果
        int j = 0; //双指针
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //j作为一个指针的情况在与s = aabb
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
