package gogogo;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-30 11:05
 */
public class Day0830 {

    /**
     * 3[a]2[bc2[a]]
     * 3[a2[b]]   abb
     * 3[a]2[b]  aaabb
     * stack相关---deque代替stack
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> letters = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            if (Character.isDigit(c)) {
                sum = sum * 10 + Integer.parseInt(c.toString());
                //nums.addFirst());
            } else if (c.equals('[')) {
                nums.addFirst(sum);
                letters.addFirst(sb.toString());
                sb = new StringBuilder();
                sum = 0;
            } else if (c >= 'a' && c<= 'z') {
                sb.append(c.toString());
            } else {
                StringBuilder tmp = new StringBuilder();
                Integer num = nums.removeFirst();
                //String letter = letters.removeFirst();
                for (Integer i = 0; i < num; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder().append(letters.removeFirst()).append(tmp);

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        Day0830 day0830 = new Day0830();
        String s = day0830.decodeString("2[bc2[a]]");
        System.out.println(s);

    }


    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private Integer capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.get(key) == null ? -1 : super.get(key);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }




    }


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        for (char c : chars) {
            nums[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if ( nums[chars[i] - 'a']  == 1) return i;
        }
        return -1;
    }
}




