package January.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/19 17:35
 */


public class Valid {

    public static void main(String[] args) {
        Valid valid = new Valid();
        boolean valid1 = valid.isValid("()");
        System.out.printf("" + valid1);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        /**Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used
         in preference to the legacy Stack class. When a deque is used as a stack,
         elements are pushed and popped from the beginning of the deque. Stack methods are precisely
         equivalent to Deque methods as indicated in the table below:*/
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addFirst(')');
            } else if (s.charAt(i) == '[') {
                deque.addFirst(']');
            } else if (s.charAt(i) == '{') {
                deque.addFirst('}');
            }
            //三种情况
            else if (deque.isEmpty() || s.charAt(i) != deque.removeFirst()) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
