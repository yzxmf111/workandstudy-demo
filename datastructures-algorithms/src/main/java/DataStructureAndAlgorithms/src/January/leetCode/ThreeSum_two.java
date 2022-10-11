package January.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 双指针 + 去重
 * @author: Tian
 * @time: 2021/1/27 16:37
 */

public class ThreeSum_two {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return list;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            //双指针
            int left = i + 1, right = nums.length - 1;
            //--等号需不需要? --不需要
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    list.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    //保证不重不漏
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
