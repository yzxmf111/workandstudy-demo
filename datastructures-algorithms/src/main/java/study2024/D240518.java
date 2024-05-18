package study2024;

import cn.hutool.core.text.StrBuilder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: yzxmf
 * @Date: 2024/05/18/19:03
 * @Description: 复习
 */
public class D240518 {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack  = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(')');
            } else if (s.charAt(i) == '[') {
                stack.addLast(']');
            } else if (s.charAt(i) == '{') {
                stack.addLast('}');
            } else if (stack.isEmpty() || stack.removeLast() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int preNum = 0;
        for (int i = 0; i < s.length(); i++) {
            //数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                preNum = preNum * 10 +  s.charAt(i) - '0';
            }
            //入栈
            else if (s.charAt(i) == '[') {
                numStack.addLast(preNum);
                strStack.addLast(sb.toString());
                sb = new StringBuilder();
                preNum = 0;
            }
            //出栈
            else if (s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder();
                int size = numStack.removeLast();
                String repStr = strStack.removeLast();
                for (int k = 0; k < size; k++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(repStr + tmp.toString());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s ="100[leetcode]";
        D240518 d240518 = new D240518();
        String s1 = d240518.decodeString(s);
        System.out.println(s1);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //入
            while (!deque.isEmpty()  && nums[deque.peekLast()] <=  nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //出
            if (i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }
            //答案
            if (i - k + 1 >= 0) {
                res[j++] = nums[deque.peekFirst()];
            }

        }
        return res;
    }

}
