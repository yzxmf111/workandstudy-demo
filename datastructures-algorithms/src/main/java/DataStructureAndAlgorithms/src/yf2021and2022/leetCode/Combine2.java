package January.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/28 17:53
 */


public class Combine2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (n < k || k < 0) return list;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1,n,k,path,list);
        return list;
    }

    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(i + 1,n,k,path,list);
            path.removeLast();
        }
    }
}
