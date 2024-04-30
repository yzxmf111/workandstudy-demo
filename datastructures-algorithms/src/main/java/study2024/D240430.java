package study2024;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yzxmf
 * @Date: 2024/04/30/23:13
 * @Description:
 */
public class D240430 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int leftIndex = mid;
                while (leftIndex > left && nums[leftIndex] == nums[leftIndex - 1]) {
                    leftIndex--;
                }
                res[0] = leftIndex;
                int rightIndex = mid;
                while (rightIndex < right && nums[rightIndex] == nums[rightIndex + 1]) {
                    rightIndex++;
                }
                res[1] = rightIndex;
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

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

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        int subMax = 0, max = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {

            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num)) {
                subMax++;
                num++;
            }
            max = Math.max(subMax, max);
            subMax = 0;
        }
        return max;
    }
}
