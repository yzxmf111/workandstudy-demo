package November.ywqz;

import java.util.Arrays;
import java.util.Random;

public class FastSort {
        // 快速排序 1：基本快速排序
        /**
         * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
         */
        private static final int INSERTION_SORT_THRESHOLD = 7;

        private static final Random RANDOM = new Random();

        public static int[] sortArray(int[] nums) {
            int len = nums.length;
            quickSort(nums, 0, len - 1);
            return nums;
        }

        private static void quickSort(int[] nums, int left, int right) {
            // 小区间使用插入排序 -- 递归的终止条件
            if (right - left < INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, left, right);
                return;
            }
            //问题分解成子问题,子问题再向下递归
            int pIndex = partition(nums, left, right);
            quickSort(nums, left, pIndex - 1);
            quickSort(nums, pIndex + 1, right);
        }

        /**
         * 对数组 nums 的子区间 [left, right] 使用插入排序
         *
         * @param nums  给定数组
         * @param left  左边界，能取到
         * @param right 右边界，能取到
         */
        private static void insertionSort(int[] nums, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = nums[i];
                int j = i;
                while (j > left && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
        }

        private static int partition(int[] nums, int left, int right) {
            int randomIndex = RANDOM.nextInt(right - left + 1) + left;
            //为了防止出现数组有序或者无序的情况
            swap(nums, left, randomIndex);
            // 基准值
            int pivot = nums[left];
            int lt = left;
            // 循环不变量：
            // all in [left + 1, lt] < pivot
            // all in [lt + 1, i) >= pivot
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    lt++;
                    swap(nums, i, lt);
                }
            }
            //确定了一个元素的位置
            swap(nums, left, lt);
            return lt;
        }

        private static void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    public static void main(String[] args) {

        int[] arr = {4,5,8,7,11,28,5,3};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    }

