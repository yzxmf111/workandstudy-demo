package March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/2 17:12
 */


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //关键在与去重
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            //剪枝
            int max = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if (max < 0) continue;
            if (min > 0) break;
            while (j < k) {
                int ans = nums[i] + nums[j] + nums[k];
                if (ans == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (ans > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}
