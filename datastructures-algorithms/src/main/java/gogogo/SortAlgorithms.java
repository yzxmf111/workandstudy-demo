package gogogo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author xiaotian
 * @description 多种排序算法(升序)
 * @date 2022-09-27 16:42
 */
public class SortAlgorithms {

    //原时间复杂度o(n^2), 经过优化好多了
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int size = nums.length, temp;
        boolean flag = false;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 1; j < size - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        return nums;
    }

    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int size = nums.length, temp;
        for (int i = 1; i < size; i++) {
            temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int size = nums.length, min, minIndex;
        for (int i = 0; i < size - 1; i++) {
            //    1.找最小

            min = nums[i];
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            //    2.交换
            nums[minIndex] = nums[i];
            nums[i] = min;
        }

        return nums;
    }

    /**
     * 思想：分治 分到不可再分为止，开始合并有序数组，小范围内可使用插入排序，性能佳
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {


        return nums;
    }

    public static int[] fastSort(int[] nums) {
        return nums;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        //int[] ints = SortAlgorithms.bubbleSort(nums);
        //int[] ints = SortAlgorithms.insertSort(nums);
        int[] ints = SortAlgorithms.selectSort(nums);
        long end = System.currentTimeMillis();
        String s = Arrays.toString(ints);
        System.out.println(s + "---花费时间:" + (end - start) + "ms");

    }
}
