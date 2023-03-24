package November.practice02;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,3,7,6,4,2};
        helper(nums);
        System.out.println(Arrays.toString(nums));;
    }

    private static void helper(int[] nums) {
        int temp = 0;
        boolean flag = false;//剪枝
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1]  < nums[j]) {
                    temp = nums[j+ 1];
                    nums[j +1 ] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }

            }
            if (flag) {
                flag = false;
            }else {
                break;
            }
        }
    }
}
