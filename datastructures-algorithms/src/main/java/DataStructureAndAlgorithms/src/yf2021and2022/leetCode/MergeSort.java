package January.leetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/26 21:18
 */


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 2, 66, 23};
        //递归算法 肯定是要有左右边界的
        MergeSort ms = new MergeSort();
        int[] temp = new int[arr.length];
        //temp数组的目的在于减少额外的空间复杂度
        //在temp这样的临时数组中进行排序,最后还要copy会原来的数组
        ms.mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分治算法: 把一个大问题分解成子问题,递归的解决
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的终止条件
        if (left >= right) return;
        //防止整型溢出
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        //对于"=" 的加与不加, 视情况而定, 可以使用特例进行判断
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //现在将未进行排序继续在临时数组中进行排序,并copy给原来的数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int m = 0;
        while (left <= right) {
            arr[left++] = temp[m++];
        }
    }
}
