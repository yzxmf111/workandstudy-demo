package gogogo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,3,9};
        int[] temp = new int[nums.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
//        int mid = left + (right - left) / 2;
        int mid =(right + left) >> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left,mid, right, temp);

    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int t = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }
        int n = 0;
        for(int m = left; m <= right; m++, n++) {
            nums[m] = temp[n];
        }
    }
}
