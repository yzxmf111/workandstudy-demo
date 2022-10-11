package January.leetCode;

import java.util.*;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/27 17:18
 */


public class TopK {


    public static void main(String[] args) {
        TopK T = new TopK();
        int[] nums = {4,1,-1,2,-1,2,3};
        int[] ints = T.topKFrequent(nums, 2);
        System.out.println(ints);


    }
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < k) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        Set<Integer> set = map.keySet();
        int m = 0;

        for (Integer i : set) {
            if (m < k) {
                pq.offer(i);
                m++;
            } else {
                int n = pq.peek();
                if (map.get(n) < map.get(i)) {
                    pq.remove();
                    pq.add(i);
                }
            }
        }
        int[] ans = new int[pq.size()];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
