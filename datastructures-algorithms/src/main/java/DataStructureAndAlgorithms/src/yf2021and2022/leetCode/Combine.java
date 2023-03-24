package January.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯算法是对所有结果集的遍历, 其中包含最优解和非最优解, 是深度优先算法+path对结果的存储
 * 需要特别注意的是回溯算法往往有回头的过程(为了path的复用).
 * <p>
 * 回溯算法最好结合自己画出的递归树进行解答, 根据递归树的不同, 代码也不同--个人比较喜欢选与不选
 * 回溯算法每层处理的逻辑相同(递归),区别在于递归的起点不同--for循环来实现
 */


public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(combine1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (k < 0 || k > n) return list;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1, n,k, path, list);
        return list;
    }

    /**
     * @param begin 每层的起点,
     * @param k
     * @param path
     * @param list
     */
    private void dfs(int begin,int n, int k, Deque<Integer> path, List<List<Integer>> list) {
        //递归的终止条件
        if (path.size() == k) {
            // list.add(path); 出现错误的结果,原因在于path只有一份引用
            // 除非你每次都创建一个path(此时也不用回头了),否则不可使用这种写法
            list.add(new ArrayList<>(path));
            //mark
            return;
        }
        //回溯算法由于 for循环的存在使得递归树可以成立
        //mark 终点为 n
        for (int i = begin; i <= n ; i++) {
            path.addLast(i);
            //mark: i + 1 而不是 begin + 1
            dfs(i + 1, n,k, path, list);
            path.removeLast();
        }
    }
}
