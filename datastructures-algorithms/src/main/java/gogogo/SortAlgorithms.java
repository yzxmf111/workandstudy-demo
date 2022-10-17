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

    private static final int FIX_LENGTH = 7;

    private static Random random = new Random();

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
     * 空间复杂度：O(n + logn) 时间复杂度 ：每层都要排序 X 层数 o(n) * o(logn)
     *
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        mergeNums(nums, 0, length - 1, temp);
        return nums;
    }

    private static void mergeNums(int[] nums, int left, int right, int[] temp) {
        if (right - left <= 0) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeNums(nums, left, mid, temp);
        mergeNums(nums, mid + 1, right, temp);
        // 优化 2：如果数组已经有序，无须再合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, left, mid, right, temp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
                k++;
            } else {
                nums[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= right) {
            nums[k++] = temp[j++];
        }


    }

    public static int[] fastSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        fast(nums, 0, nums.length - 1);
        return nums;
    }

    private static void fast(int[] nums, int left, int right) {
        if (right - left <= FIX_LENGTH) {
//            小区间 插入排序 性能接近 O（n）---------------------
            insertSortTwo(nums, left, right);
            return;
        }
        //if (right<=left) return;
        //减治的思想
        int fixIndex = fixElement(nums, left, right);
        fast(nums, left, fixIndex - 1);
        fast(nums, fixIndex + 1, right);
    }

    private static int fixElement(int[] nums, int left, int right) {
        int index = random.nextInt(right - left + 1) + left;
        swap(nums, index, left);
        int swapIndex = left;
        int firstRandomNum = nums[swapIndex];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= firstRandomNum) {
                swapIndex++;
                swap(nums, i, swapIndex);
            }
        }
        swap(nums, left, swapIndex);
        return swapIndex;
    }

    private static void swap(int[] nums, int index, int left) {
        int temp = nums[index];
        nums[index] = nums[left];
        nums[left] = temp;
    }


    private static void insertSortTwo(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = nums[i];
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            nums[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
//        int[] ints = SortAlgorithms.bubbleSort(nums);
//        int[] ints = SortAlgorithms.insertSort(nums);
//        int[] ints = SortAlgorithms.selectSort(nums);
        int[] ints = SortAlgorithms.mergeSort(nums);
//        int[] ints = SortAlgorithms.fastSort(nums);
        //int[] nums = {8,6,4,5,9,1 ,12,34,5451,213,1,22,2,1,22};
        //int[] ints = SortAlgorithms.fastSort(nums);
        long end = System.currentTimeMillis();
        String s = Arrays.toString(ints);
        System.out.println(s + "---花费时间:" + (end - start) + "ms");

    }
}
