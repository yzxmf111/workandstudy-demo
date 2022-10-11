package January.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/27 22:24
 */


public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,list, path,0,0,target);
        return list;
    }

    /**
     * 在我们自己画出的递归树中,每个节点处理的事情都是一样的, 只不过是起点不同罢了 for循环实现
     * @param candidates
     * @param list
     * @param begin
     * @param sum
     * @param target
     */
    private void dfs(int[] candidates, List<List<Integer>> list,Deque<Integer> path, int begin, int sum, int target) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        //在这里可以进行剪枝
        if (sum > target) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
                dfs(candidates, list, path, i , sum + candidates[i],target);
            path.removeLast();
        }
    }
}
