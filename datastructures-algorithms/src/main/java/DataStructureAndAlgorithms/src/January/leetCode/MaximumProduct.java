package January.leetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/20 17:57
 */


public class MaximumProduct {

    public static void main(String[] args) {
        MaximumProduct ans = new MaximumProduct();
        int[] a = {-2,-2,2,3,4};
        int i = ans.maximumProduct(a);
        System.out.println(i);
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[len-1] * nums[len - 2] * nums[len - 3];
        int b = nums[len - 1] * nums[0] * nums[1];
        return Math.max(a,b);
    }
}
