package March;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/5 17:47
 */


public class QuickSort {


    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        Long start = System.currentTimeMillis();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = (int) (Math.random() * 10 * 10 * 10000);
        }
        Long end = System.currentTimeMillis();
        quick.fastSort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
        System.out.println((end - start) + " ms");
    }

    private static final int THRESHOILD = 7;
    private static final Random RANDOM  = new Random();

    /**
     * 在基础版的基础上还可以进行优化
     *
     * @param nums
     * @param left
     * @param right
     */
    private void fastSort(int[] nums, int left, int right) {
        //mark:1
        if (right - left < THRESHOILD) {
            insertSort(nums);
            return;
        }
        if (left >= right) return;
        //每次确定元素的位置, 然后递归的向左向右
        int partitionIndex = partition(nums, left, right);
        fastSort(nums, left, partitionIndex - 1);
        fastSort(nums, partitionIndex + 1, right);
    }

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];
            while(j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = temp;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int random = RANDOM.nextInt(right - left + 1) + left;
        swap(nums,left,random);
        //mark:2
        int center = nums[left]; // 基准值
        int lt = left;  //记录着最后一个小于center的元素的下标
        //大放过,小替换
        //mark:3 i < right
        for (int i = lt + 1; i <= right; i++) {
            if (nums[i] < center) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    private void swap(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;


    }
}
