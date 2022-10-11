package March;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/8 19:53
 */


public class TestSort {

    public static void main(String[] args) {
        TestSort quick = new TestSort();
        Long start = System.currentTimeMillis();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = (int) (Math.random() * 10 * 10 * 10000);
        }
        Long end = System.currentTimeMillis();
        quick.fastSort(arr);
        System.out.print(Arrays.toString(arr));
        System.out.println((end - start) + " ms");
    }

    private static final Random RANDOM = new Random();
    private static final int THRESHOLD = 7;

    public void fastSort(int[] nums) {
        int left = 0, right = nums.length - 1;
        div(nums, left, right);
    }

    private void div(int[] nums, int left, int right) {
        if (right - left <= THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int partition = partitionNums(nums, left, right);
        div(nums, left, partition - 1);
        div(nums, partition + 1, right);
    }

    private int partitionNums(int[] nums, int left, int right) {
        //为防止原本的nums数组有序
        int lt = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, lt);
        lt = left; //lt记录着最后一个小于center的元素
        int center = nums[lt];
        //大放过,小交换.
        for (int i = lt + 1; i <= right; i++) {
            if (nums[i] < center) {
                lt++;
                swap(nums,i,lt);
            } else {
                continue;
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    private void swap(int[] nums, int left, int lt) {
        int temp = nums[left];
        nums[left] = nums[lt];
        nums[lt] = temp;
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = nums[j];
            //mark: 1
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = temp;
            } else {
                break;
            }
        }
    }
}
