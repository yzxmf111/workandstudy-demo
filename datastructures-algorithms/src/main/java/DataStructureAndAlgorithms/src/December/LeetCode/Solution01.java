package December.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution01 {


    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {

        int ans = 0, a = 0, b = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //这才是大顶堆
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            a = pq.poll();
            b = pq.poll();
            ans = a - b;
            if (ans > 0) {
                pq.add(ans);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    private static void insertSort(int[] stones) {

        for (int i = 1; i < stones.length - 1; i++) {
            int j = i;
            int temp = stones[j];
            while (j > 0 && stones[j - 1] > temp) {
                stones[j] = stones[j - 1];
                j--;
            }
            if (j != i) {
                stones[j] = temp;
            }
        }

    }
}
