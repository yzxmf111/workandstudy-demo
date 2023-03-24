package March;


import November.ZS.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/2 17:06
 */


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.fib(3);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        //int[] nums = new int[x];
        //这是一个优化
        int left = 0, right = x;
        int mid = 0;
        //= 使用特例判断的
        while (left < right) {
            mid = left + (right - left + 1) >>> 1;
            if ((long) (mid * mid) > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }


    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null && prev.val > root.val) {
            return false;
        }
        prev = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     * 我们现在主要处理进位的问题.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0; //用于处理进位问题
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(carry);
        return pre.next;
    }



        public int lengthOfLongestSubstring(String s) {
            List<Character> list = new ArrayList();
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (!list.contains(s.charAt(j))) {
                        list.add(s.charAt(j));
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, list.size());
                list.clear();
            }
            return ans;
        }

    public int fib(int n) {
        int sum = 0, a = 0, b = 1;
        // if (n < 2) return n;
        // int[] dp = new int[n + 1];
        //dp[0] = 0;
        //dp[1] = 1;
        for(int i= 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            // dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


}
