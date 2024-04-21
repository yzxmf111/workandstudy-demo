package study2024;

import java.util.*;

/**
 * @Author: yxxmf
 * @Date: 2024/04/21/18:29
 * @Description: 回溯算法
 */
public class D240421 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(1, n, k, res, deque);
        return res;
    }

    private void dfs(int begin, int n, int k, List<List<Integer>> res, Deque<Integer> deque) {
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i <= n; i++) {
            deque.addFirst(i);
            dfs(i + 1, n, k, res, deque);
            deque.removeFirst();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfsForSum(0, 0, target, candidates, res, deque);
        return res;
    }

    private void dfsForSum(int begin, int sum, int target, int[] candidates, List<List<Integer>> res, Deque<Integer> deque) {
        if (sum == target) {
            res.add(new ArrayList<>(deque));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            deque.addFirst(candidates[i]);
            dfsForSum(i, sum + candidates[i], target, candidates, res, deque);
            deque.removeFirst();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfsForPermute(res, nums, deque, used);
        return res;
    }

    private void dfsForPermute(List<List<Integer>> res, int[] nums, Deque<Integer> deque, boolean[] used) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                deque.addFirst(nums[i]);
                used[i] = true;
                dfsForPermute(res, nums, deque, used);
                deque.removeFirst();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfsForPermuteUnique(res, nums, deque, used);
        return res;
    }


    private void dfsForPermuteUnique(List<List<Integer>> res, int[] nums, Deque<Integer> deque, boolean[] used) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                deque.addFirst(nums[i]);
                used[i] = true;
                dfsForPermuteUnique(res, nums, deque, used);
                deque.removeFirst();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            sum += i;
        }
        if (sum > n) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        dfsForCombinationSum3(1, 0, k, n, res, deque);
        return res;
    }

    private void dfsForCombinationSum3(int begin, int sum, int k, int n, List<List<Integer>> res, Deque<Integer> deque) {
        if (k == deque.size() && sum == n) {
            res.add(new ArrayList<>(deque));
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = begin; i <= 9; i++) {
            deque.addFirst(i);
            dfsForCombinationSum3(i + 1, sum + i, k, n, res, deque);
            deque.removeFirst();
        }
    }

    public static void main(String[] args) {
        D240421 d240421 = new D240421();
        List<List<Integer>> lists = d240421.combinationSum3(3, 7);
        System.out.println(lists);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfsForSubSets(0, nums, res, stack);
        return res;
    }

    private void dfsForSubSets(int begin, int[] nums, List<List<Integer>> res, Deque<Integer> stack) {
        res.add(new ArrayList<>(stack));
        if (stack.size() == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            stack.addFirst(nums[i]);
            dfsForSubSets(i + 1, nums, res, stack);
            stack.removeFirst();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfsForSubsetsWithDup(0, nums, used, res, stack);
        return res;
    }

    private void dfsForSubsetsWithDup(int begin, int[] nums, boolean[] used, List<List<Integer>> res, Deque<Integer> stack) {
        res.add(new ArrayList<>(stack));
        if (stack.size() == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                stack.addFirst(nums[i]);
                used[i] = true;
                dfsForSubsetsWithDup(i + 1, nums, used, res, stack);
                stack.removeFirst();
                used[i] = false;
            }
        }
    }

}
