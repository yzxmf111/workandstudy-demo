package gogogo;

import java.util.*;

/**
 * @author xiaotian
 * @description 前k个高频元素---时间复杂度要求 小于 o(nlogn)
 * @date 2022-06-20 15:47
 */
public class Day620 {

    public static void main(String[] args) {
        int[] nums = {1,3,3,45,6,6,6,6};
        int[] ints = topK(nums, 2);
        System.out.println(Arrays.toString(ints));

    }
    /**
     * methodOne: 暴力排序，取前k个，时间时间复杂度均>= o(nlogn)
     * methodTwo: 构造大小为k的小顶堆 时间时间复杂度为 o(nlogk) < o(nlogn)
     */
    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //Arrays.asList(num).stream().collect(Collectors.toMap(
        //
        //))
        for (Integer num : nums) {
            //统计数字出现的次数
            map.put(num, map.getOrDefault(num, 0) + 1);
            //if (map.get(num) == null) {
            //    map.put(num, 1);
            //} else {
            //    map.put(num, map.get(num) + 1)
            //}
        }
        //优先队列的底层是堆，创建的时候默认是小顶堆
        Queue<Integer> pq = new PriorityQueue<>(
                (o1,o2) -> map.get(o1) - map.get(o2)
        );

        int j = 0;
        Set<Integer> set = map.keySet();
        for (Integer num : set) {
            if (j < k) {
                pq.offer(num);
                j++;
            } else {
                Integer top = pq.peek();
                if (map.get(num) > map.get(top)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = pq.poll();
        }
        return ints;

    }
}
