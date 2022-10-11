package gogogo;

import java.util.Deque;
import java.util.LinkedList;

public class day001 {

    /**
     * 字符串解码，3[a2[cd]] 通过观察，这种解码方式与 栈 的结构很像，采用辅助栈法
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Integer num = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                //防止 32[a] 出现
                num = num * 10 + Integer.parseInt(chars[i] + "");
            } else if (chars[i] == '[') {
                numStack.addFirst(num);
                strStack.addFirst(sb.toString());
                //置为原始值
                num = 0;
                sb = new StringBuilder();
            } else if (chars[i] == ']') {
                StringBuilder temp = new StringBuilder();
                Integer size = numStack.removeFirst();
                for (Integer j = 0; j < size; j++) {
                    temp.append(sb);
                }
                sb = new StringBuilder().append(strStack.removeFirst()).append(temp.toString());
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        day001 day001 = new day001();
        String s = day001.decodeString("3[a2[cd]]");
        System.out.println(s);
    }


}
