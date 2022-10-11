package November.futureuptome;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 34, 4, 3, 5, 2};
        int len = arr.length;
        int[] temp = new int[len];
        mergeSort(arr, 0, len - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的终止条件
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        //排序
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //copy回原来的数组
        int m = 0;
        while (left <= right) {
            arr[left++] = temp[m++];
        }
    }
}
