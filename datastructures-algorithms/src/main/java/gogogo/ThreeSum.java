package gogogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-06 19:14
 */
public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else {
                    left++;
                }

            }
        }
        return res;
    }
}
