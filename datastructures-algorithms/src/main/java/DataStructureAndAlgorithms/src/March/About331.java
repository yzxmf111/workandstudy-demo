package March;

import java.util.*;

public class About331 {

    /**
     * 含有重复数字的子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        dfs(0, len, used, list, path, nums);
        return list;
    }

    private void dfs(int begin, int end, boolean[] used, List<List<Integer>> list, Deque<Integer> path, int[] nums) {
        list.add(new ArrayList<>(path));
        System.out.println(list);
        for (int i = begin; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {continue;}
                    path.addLast(nums[i]);
                    used[i] = true;
                    dfs(i + 1, end, used, list, path, nums);
                    path.removeLast();
                    used[i] = false;

        }
    }
    }


   /* public List<List<Integer>> subsets(int[] nums) {
        //O(n*n!) O(n)
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, nums, path, list);
        return list;
    }

    private void dfs(int index, int[] nums, Deque<Integer> path, List<List<Integer>> list) {
        list.add(new ArrayList<>(path));
        System.out.println(list);
        for (int i = index; i < nums.length; i++) {
            System.out.println(i);
            path.addLast(nums[i]);
            dfs(i + 1, nums, path, list);
            path.removeLast();
        }
    }*/

    public static void main(String[] args) {
        About331 ans = new About331();
        int[] arr = {4,4,4,1,4};
        List<List<Integer>> subsets = ans.subsetsWithDup(arr);
        System.out.println(subsets);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            //也要先去重复
           if (set1.contains(nums2[i])) {
               list.add(nums2[i]);
               set1.remove(nums2[i]);
           }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}