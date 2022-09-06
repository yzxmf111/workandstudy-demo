package gogogo;

import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-06 15:39
 */
public class Day0906 {

    private static final Logger logger = LoggerFactory.getLogger(Day0906.class);


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return list;
        Deque<Integer> path = new ArrayDeque<>();
        findRes(0, 0, candidates, target, list, path);
        return list;
    }

    private void findRes(int begin, int sum, int[] candidates, int target, List<List<Integer>> list, Deque<Integer> path) {
        //for (int i = 0; i < path.size(); i++) {
        //    //sum+=path.p
        //}
        //path.
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        //begin才能做到不重复
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            //i才能不重复
            findRes(i, candidates[i] + sum, candidates, target, list, path);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Day0906 day0906 = new Day0906();
        int[] nums = {1, 2, 3,4,5,6};
        List<List<Integer>> combine = day0906.combinationSum(nums, 8);
        logger.info(combine.toString());
    }
}
