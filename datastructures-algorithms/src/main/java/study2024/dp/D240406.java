package study2024.dp;

import study2024.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description 翻转二叉树、合并二叉树、最长回文串
 * @date 2024-04-06 16:53
 */
public class D240406 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        boolean flag = false;
        int sum = 0;
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 1) {
                flag = true;
                sum += value - 1;
            } else {
                sum += value;
            }
        }
        return flag ? sum + 1 : sum;

    }

    public static void main(String[] args) {
        System.out.println('a' - 'a');
        System.out.println('A' - 'a');
       new D240406().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    /**
     * k(n-1) + sum = target*n
     * target = min + k
     * k(n-1) + sum = (min + k)n
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        long sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int) sum - min * nums.length;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (nums[mid] == target) {
                int tmp1 = mid;
                int tmp2 = mid;
                while (tmp1-1 >= 0 && nums[tmp1 - 1] == target) {
                    tmp1--;
                }
                while (tmp2 + 1 <= nums.length - 1 && nums[tmp2 + 1] == target) {
                    tmp2++;
                }

                return new int[]{tmp1, tmp2};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 寻找峰值：二分查找，大的一边一定有峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
