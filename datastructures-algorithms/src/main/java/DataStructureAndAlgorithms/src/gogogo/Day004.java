package gogogo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day004 {

    public static void main(String[] args) {
        Day004 day004 = new Day004();
        boolean b = day004.wordPattern2("aabb", "dog dog cat cat");
        System.out.println(b);
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                //包含就看之前key对应的value与此时的value是否相同
                //我们需要的是双向匹配
                if (!split[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                //不包含有两种 --map的value集合已经有了split[i]  or 没有
                //我们需要的是双向匹配
                if (map.values().contains(split[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), split[i]);
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        Map<Object, Integer> map = new HashMap<>();
        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), (map.put(split[i], i)))) {
                return false;
            }
        }
        return true;
    }
}

//abba
//cat dog dog cat
