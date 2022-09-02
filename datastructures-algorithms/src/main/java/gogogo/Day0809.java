package gogogo;

import java.util.*;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-09 17:04
 */
public class Day0809 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        //排好序才好剪枝
        Arrays.sort(nums);
        dfs(0, len, nums, path, used, list);
        return list;
    }

    private void dfs(int deepth, int len, int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> list) {
        if (deepth == len) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                //可以继续使用
                if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                    //如果刚刚回溯过,一会就又被选出来了,会出现重复,剪枝当在此刻
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(deepth + 1, len, nums, path, used, list);
                used[i] = false;
                path.removeLast();
            }
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k < 0 || k > n) return list;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1, n, k, path, list);
        return list;
    }

    /**
     * @param begin 每层的起点,
     * @param k
     * @param path
     * @param list
     */
    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> list) {
        //递归的终止条件
        if (path.size() == k) {
            // list.add(path); 出现错误的结果,原因在于path只有一份引用
            // 除非你每次都创建一个path(此时也不用回头了),否则不可使用这种写法
            list.add(new ArrayList<>(path));
            return;
        }
        //回溯算法由于 for循环的存在使得递归树可以成立
        //mark:1 终点为 n
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            //mark:2 i+1 而非是 begin + 1 : 不要人肉递归
            dfs(i + 1, n, k, path, list);
            path.removeLast();
        }
    }

}
