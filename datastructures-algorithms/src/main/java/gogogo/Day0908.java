package gogogo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-08 17:43
 */
public class Day0908 {

    public boolean wordPattern(String pattern, String s) {
        //
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!words[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (map.values().contains(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}
