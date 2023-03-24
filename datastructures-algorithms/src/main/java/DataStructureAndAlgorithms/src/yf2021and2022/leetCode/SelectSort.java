package January.leetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/28 17:46
 */


public class SelectSort {

    public static void main(String[] args) {

        SelectSort solution = new SelectSort();
        int[] nums = {5, 5, 4, 1, 7, 5, 9, 3, 58};
        solution.selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 何为选择排序, 即每次选择最大/小的放在前/后边
     *
     * @param nums
     */
    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIndex = i ;
//            int temp
            for ( int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (min != nums[i]) {
                //交换两者的位置
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }
}
