package study2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yzxmf
 * @Date: 2024/05/25/17:35
 * @Description:
 */
public class D240525 {

    /**
     * 1248 优美子数组
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, sum = 0, right = left, target = 0;

        while (right < nums.length) {
            if (nums[right++] % 2 == 1) {
                target++;
            }
            if (target == k) {
                int leftEventNum = 0, rightEventNum = 0;
                while (nums[left] % 2 == 0) {
                    leftEventNum++;
                    left++;
                }
                while (right < nums.length && nums[right] % 2 == 0) {
                    rightEventNum++;
                    right++;
                }
                sum += (leftEventNum + 1) * (rightEventNum + 1);
                left++;
                target--;
            }
        }
        return sum;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preOddNum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                preOddNum++;
            }
            if (map.containsKey(k - preOddNum)) {
               sum += map.get(k - preOddNum) ;
            }
            map.put(preOddNum, map.getOrDefault(preOddNum, 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,2,1,2};
        int target = 2;
        int i = new D240525().numberOfSubarrays2(nums, target);
        System.out.println(i);
    }
}
