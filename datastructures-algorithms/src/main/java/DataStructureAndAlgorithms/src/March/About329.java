package March;

import November.ZS.ListNode;

import java.util.*;

public class About329 {

    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map;
    int start = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        map = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);//k-v 中的v值的目的在于以后递归的向左向右进行查询
        }
        TreeNode root = helper(0, len - 1);
        return root;
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[start++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        return root;
    }

  /*  public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        About329 ans = new About329();
        TreeNode root = ans.buildTree(preorder, inorder);
        System.out.println(root);

    }*/

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int m = 0, n = list.size() - 1;
        //对于 '=' 使用特例进行判断
        while (m < n) {
            list.get(m).next = list.get(n);
            m++;
            if (m >= n) break;
            list.get(n).next = list.get(m);
            n--;
            if (m >= n) break;
        }
        list.get(m).next = null;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int len = typed.length();
        int m = 0;
        int n = 0;
        while (n < len) {
            if (m < name.length() && name.charAt(m) == typed.charAt(n)) {
                m++;
                n++;
            } else if (n > 0 && typed.charAt(n) == typed.charAt(n - 1)) {
                n++;
            } else {
                return false;
            }
        }
        if (m >= name.length()) return true;
        else return false;
    }

    public static void main(String[] args) {
        //String name = "alex";
        String typed = "3/2";
        About329 ans = new About329();
        int res = ans.calculate(typed);
        System.out.println(res);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        int ans =0;
        int i = 0;
        while(i < s.length()) {
            //1.是空格
            while (chars[i] == ' ') {
                i++;
            }
            //2.是加减乘除
            char temp = chars[i];
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                i++;
                while (chars[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            while (i < s.length() && Character.isDigit(chars[i])) {
                //防止 42 + 3 或者 425 表达式的出现
                num = num * 10 + chars[i] - '0';
                i++;
            }

            switch (temp) {
                case '+' : {
                    num = num;
                    break;
                } case '-': {
                    num = -num;
                    break;
                } case '*': {
                    num = deque.remove() * num;
                    break;
                } case '/': {
                   num = deque.removeLast() / num;
                    break;
                }
            }
            deque.addLast(num);
        }
        while (deque.size() != 0) {
            ans += deque.removeLast();
        }
        return ans;
    }
}
