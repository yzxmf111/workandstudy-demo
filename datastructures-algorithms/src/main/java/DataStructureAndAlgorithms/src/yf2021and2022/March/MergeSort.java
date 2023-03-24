package March;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/5 17:07
 */


public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,6,3,2,8,9};
        MergeSort ans = new MergeSort();
        int[] ints = ans.mergeSort(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int left = 0, len = nums.length, right = len - 1;
        //mark:1 仅仅开辟一个临时数组
        int[] temp = new int[len];
        div(left, right, nums, temp);
        return nums;
    }

    private void div(int left, int right, int[] nums, int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        //mark:2 递归的分分分
        div(left, mid, nums, temp);
        div(mid + 1, right, nums, temp);
        //mark:3 递归的和和和
        merge(left, mid, right, nums, temp);
    }

    //合并两个有序数组
    private void merge(int left, int mid, int right, int[] nums, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //复制元素
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        //继续复制
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        //copy回原来的数组
        int m = 0;
        //mark: 3
        while(left <= right) {
            nums[left++] = temp[m++];
        }
    }
}
