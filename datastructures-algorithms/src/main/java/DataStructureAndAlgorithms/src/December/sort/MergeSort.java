package December.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Long start = System.currentTimeMillis();
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = (int)(Math.random() * 10 *10 * 10000);
        }
        Long end = System.currentTimeMillis();
        int[] temp = new int[arr.length];
        mergeSort.mergeSort(arr,0,arr.length -1,temp);
        System.out.println(Arrays.toString(arr)  );
        System.out.println((end - start) + " ms");
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的终止条件
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    /**
     * @param arr
     * @param mid
     * @param left
     * @param right
     * @param temp
     * @Description 合并的方法
     */
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //继续排元素到数组中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //copy回原数组
        int n = 0;
        for (int m = left; m <= right; m++) {
            arr[m]  = temp[n++];
        }
    }

}
