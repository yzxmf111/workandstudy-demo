package study2024;

import java.util.*;

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


    public String removeDup(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            if (map.get(chars[i]) > 1) {
                continue;
            } else {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abbcddae";
        D240430 d240430 = new D240430();
        String res = d240430.removeDup(s);
        System.out.println(res);

        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = d240430.longestConsecutive(nums);
        System.out.println(i);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> subList = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            subList.add(str);
            map.put(String.valueOf(chars), subList);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
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
            //对于不连续的数字来说，内外层的循环只有一次。对于连续的数字只有目前的数字是当最小的，才会进入内循环，o(n)
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
