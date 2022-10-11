package January.leetCode;

import java.util.*;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/20 17:06
 */


public class TopKFrequent {

    public static void main(String[] args) {

        TopKFrequent topKFrequent = new TopKFrequent();
        int[] ans = {1, 1, 1, 2, 2, 3};
//        Arrays.sort(ans, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });

        int[] ints = topKFrequent.topKFrequent(ans, 2);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < k) return nums;
        //堆一般用于处理最大值和最小值
        Map<Integer, Integer> map = new HashMap<>();
        //记录出现频率
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        //小顶堆,比较出现频率
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                ((o1, o2) -> map.get(o1) - map.get(o2))
        );
        Set<Integer> set = map.keySet();
        int j = 0;
        for (Integer i : set) {
            if (j < k) {
                pq.add(i);
                j++;
            } else {
                int m = pq.peek();
                if (map.get(m) < map.get(i)) {
                    pq.remove();
                    pq.add(i);
                }
            }
        }
        //int[] ans = new int[k];
        /***
         * 增强for循环和iterator遍历的效果是一样的，
         * 也就说增强for循环的内部也就是调用iteratoer实现的，
         * 但是增强for循环有些缺点，例如:不能在增强循环里动态的删除集合内容、
         *                             不能获取下标等,不能修改里边的数据(jvm底层有关?)。
         *
         *                             综合来说:增强for,只能用于遍历
         */
       /* for (ints) {
            //
            Integer poll = pq.poll();
            a = poll;
            System.out.println(a);
        }
        return ans;*/
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
