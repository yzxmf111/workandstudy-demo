package January.leetCode;

import java.util.Arrays;

/**
 * @description:插入排序
 * @author: Tian
 * @time: 2021/1/26 21:35
 */


public class InsertSort {

    public static void main(String[] args) {

        InsertSort insertSort = new InsertSort();
        int[] nums = {5, 5, 4, 1, 7, 5, 9, 3, 58};
        int[] ints = insertSort.insertSort(nums);
        System.out.println(Arrays.toString(ints));
    }


    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];
            while (j > 0 && nums[j - 1] < temp) {
                //赋值
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                //说明已经进行插入了
                nums[j] = temp;
            }
        }
        return nums;
    }
}
