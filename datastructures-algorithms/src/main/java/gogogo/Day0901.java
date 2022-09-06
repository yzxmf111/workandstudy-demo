package gogogo;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-01 16:58
 */
public class Day0901 {

    private static final Logger logger = LoggerFactory.getLogger(Day0901.class);
    /**
     * 排列组合---回溯算法---树的dfs（递归）---路径即结果
     * // 1 <= n <= 20
     * // 1 <= k <= n
     *
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        findRes(1, n, k, path, list);
        return list;
    }

    private void findRes(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i); //这里不能是begin而是i，否则不能按照一定的顺序进行搜索
            findRes( i + 1, n, k, path, list); //这里不能是begin+1而是i+1，否则不能按照一定的顺序进行搜索 从第二个数看起
            //logger.info("list = {}; path = {}",list, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Day0901 day0901 = new Day0901();
        List<List<Integer>> combine = day0901.combine(3, 2);
        logger.info(combine.toString());
    }

}
