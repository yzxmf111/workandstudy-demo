package DataStructureAndAlgorithms.src.gogogo.sort;

import java.util.Arrays;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-23 17:22
 */
public class MergerSort {

    public int[] sort(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        int length = nums.length;
        int[] tmp = new int[length];
        return mergerSort(0, length - 1, nums, tmp);
    }

    private int[] mergerSort(int left, int right, int[] nums, int[] tmp) {
        if (left >= right) {
            return nums;
        }
        int mid = left + (right - left) / 2;
        mergerSort(left, mid, nums, tmp);
        mergerSort(mid + 1, right, nums, tmp);
        return merge(left, mid, right, nums, tmp);
    }

    private int[] merge(int left, int mid, int right, int[] nums, int[] tmp) {
        int i = left, j = mid + 1, k = i;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        if(i <= mid) {
            tmp[k++] = nums[i++];
        }
        if (j <= right) {
            tmp[k++] = nums[j++];

        }
        for (int l = left; l <= right; l++) {
            nums[l] = tmp[l];
        }
        return nums;
    }

    public static void main(String[] args) {
        MergerSort mergerSort = new MergerSort();
        int[] sort = mergerSort.sort(new int[]{1, 4, 23, 2});
        String s = Arrays.asList(sort).toString();
        System.out.println(s);


        int a = 9, b = 1;
        int c = (3 - 2) >> 1;
        System.out.println(c);

    }
}
