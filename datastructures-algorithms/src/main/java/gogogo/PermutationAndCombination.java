package gogogo;

import java.util.*;

/**
 * @author xiaotian
 * @description 回溯算法--排列组合
 * @date 2023-03-13 17:36
 */
public class PermutationAndCombination {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        boolean[] used = new boolean[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(nums);
        dfs(0, nums.length, nums, used, deque, list);
        return list;
    }

    private void dfs(int index, int length, int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> list) {
        if (index == length) {
            list.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            //空间换时间
            if (!used[i]) {
                //画出递归树，used[i - 1] == false 怕在顶端出错
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;

                dfs(index + 1, length, nums, used, path, list);

                path.removeLast();
                used[i] = false;
            }
        }
    }
}


//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums == null || nums.length == 0) return list;
//        int len = nums.length;
//        boolean[] used = new boolean[len];
//        // 使用 Deque 是 Java 官方 Stack 类的建议
//        Deque<Integer> path = new ArrayDeque<>();
//        Arrays.sort(nums);
//        dfs(nums, 0, len, path, used, list);
//        return list;
//    }
//
//    private void dfs(int[] nums, int deepth, int len, Deque<Integer> path, boolean[] used, List<List<Integer>> list) {
//        if (deepth == len) {
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
//                    continue;
//                }
//                path.addLast(nums[i]);
//                used[i] = true;
//                dfs(nums, deepth + 1, len, path, used, list);
//                used[i] = false;
//                path.removeLast();
//            }
//        }
//    }
//}




















//public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums == null || nums.length == 0) return list;
//        Deque<Integer> path = new ArrayDeque<>();
//        int len = nums.length;
//        boolean[] used = new boolean[len];//毕竟和组合不一样的呀....需要以空间换时间,我们可以以O(1)的时间确定某个元素是否使用过了
//        dfs(0, nums, len, path, list, used); //l 就是状态变量.
//        return list;
//    }
//
//    private void dfs(int index, int[] nums, int len, Deque<Integer> path, List<List<Integer>> list, boolean[] used) {
//        //递归的终止条件
//        if (index == len) {
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            //进行递归
//            if (!used[i]) {
//                path.addLast(nums[i]);
//                used[i] = true;
//
//
//                dfs(index + 1, nums, len, path, list, used);
//
//                //回头
//                used[i] = false;
//                path.removeLast();
//            }
//        }
//    }