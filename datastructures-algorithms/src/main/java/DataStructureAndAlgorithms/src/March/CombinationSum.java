package March;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/1 16:50
 */


public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] can = {2,3,6,7};
        List<List<Integer>> list = combinationSum.combinationSum(can, 7);
        System.out.println(list);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, 0, candidates, target, path, list);
        return list;
    }

    private void dfs(int begin, int sum, int[] candidates, int target, Deque<Integer> path, List<List<Integer>> list) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            System.out.println(path);
            System.out.println(i);
            dfs(i , sum + candidates[i], candidates, target, path, list);
            path.removeLast();
        }
    }
}