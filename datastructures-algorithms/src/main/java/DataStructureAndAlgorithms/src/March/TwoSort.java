package March;

import java.util.Arrays;
import java.util.Random;

public class TwoSort {

    public static void main(String[] args) {
        int[] arr = {6, 4, 1, 5, 89, 85, 4, 1, 485, 156, 256};
        TwoSort twoSort = new TwoSort();
        int[] ints = twoSort.quickSort(arr);
        System.out.println(Arrays.toString(ints));
        System.out.println(7 >> 1);
    }


    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int left = 0, right = arr.length - 1;
        int[] temp = new int[arr.length];
        sort(arr, temp, left, right);
        return arr;
    }

    private void sort(int[] arr, int[] temp, int left, int right) {
        //"="的选取,可以看特例判断
        if (left >= right) return;
        int mid = (right + left) >> 1;
        sort(arr, temp, left, mid);
        sort(arr, temp, mid + 1, right);
        merge(arr, temp, left, right, mid);
    }

    private void merge(int[] arr, int[] temp, int left, int right, int mid) {
        int i = left, j = mid + 1, t = 0;
        //接下来就是合并两个有序数组
        while (i <= mid && j <= right) {
            temp[t++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int m = 0;
        while (left <= right)
            arr[left++] = temp[m++];
    }

    private static final int THREADHOLD = 7;
    private static final Random RANDOM = new Random();

    //每次确定一个元素的位置, 小于它的放在左边, 大于它的放在右边
    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int left = 0, right = arr.length - 1;
        sortTwo(arr, left, right);
        return arr;
    }

    private void sortTwo(int[] arr, int left, int right) {
        if (right - left <= THREADHOLD) {
            insertation(arr, left, right);
            return;
        }
        int partation = partation(arr, left, right);
        sortTwo(arr, left, partation - 1);
        sortTwo(arr, partation + 1, right);
    }

    private int partation(int[] arr, int left, int right) {
        //可以优化基准数的选取--随机数
        int randomLeft = RANDOM.nextInt(right - left + 1);
        //交换数组头部元素 防止出现时间复杂度O(n^2)情况
        swap(arr, left, randomLeft);
        int lt = left; //记录着最后一个小于基准数的元素线标
        int center = arr[lt];
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < center) {
                lt++;
                swap(arr, lt, i);
            }
        }
        swap(arr, lt, left);
        return lt;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void insertation(int[] arr, int left, int right) {
        //int[] nums = Arrays.copyOfRange(arr, left, right + 1);
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = arr[j];
            //防止数组越界异常
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }

}
