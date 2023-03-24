package March;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/2 17:28
 */


public class Sort {

    public static void main(String[] args) {
        Sort test = new Sort();
        long start = System.currentTimeMillis();
        int[] nums = {1, 4, 2, 6, 5, 7};
//        bubbleSort(nums);
        selectSort(nums);
        System.out.printf(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {        //进行排序的总次数
            for (int j = 0; j < nums.length - 1 - i; j++) { //排序从哪里开始
                if (nums[j] > nums[j + 1]) {
                    //交换两者的顺序
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            } else {
                flag = false;
            }
        }
    }


    public static void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;        // j就是最大值所在的索引
            int temp = nums[j];
            //int value = temp;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j == i) continue;
            else {
                nums[j] = temp;
            }
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {//进行排序的总次数
            //也算是进行优化了
            int minIndex = i;
            int minValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) { //排序从哪里开始
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }
            //交换
            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = minValue;
            }
        }
    }
}
