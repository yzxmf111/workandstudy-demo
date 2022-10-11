package November.practice02;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 435, 123};
        helper(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void helper(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = i, max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    //并非最大值
                    max = nums[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                 nums[maxIndex] = nums[i];
                 nums[i] = max;
            }
        }

    }
}
