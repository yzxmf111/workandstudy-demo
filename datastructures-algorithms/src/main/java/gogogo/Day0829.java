package gogogo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-29 17:12
 */
public class Day0829 {


        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.get(target - nums[i]) != null) {
                    return new int[]{i, map.get(target - nums[i])};
                } else {
                    map.put(nums[i], i);
                }
            }
            return new int[2];
        }


        /**
         * Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used
         * in preference to the legacy Stack class. When a deque is used as a stack,
         * elements are pushed and popped from the beginning of the deque. Stack methods are precisely
         * equivalent to Deque methods as indicated in the table below:
         */
        public static boolean isValid(String s) {
            if (s == null || s.length() == 0) return true;
            char[] chars = s.toCharArray();
            Deque<Character> deque = new ArrayDeque();
            for (char c : chars) {
                if (c == '(') {
                    deque.addFirst(')');
                } else if (c == '[') {
                    deque.addFirst(']');
                } else if (c == '{') {
                    deque.addFirst('}');
                } else if (deque.isEmpty() || c != deque.removeFirst()) {
                    return false;
                }
            }
            return deque.isEmpty()? true : false;
        }

    public static void main(String[] args) {
        String s = "{()[]}";
        boolean valid = Day0829.isValid(s);
        System.out.println(valid);
    }

}
