package November.ywqz;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 1, 4, 8, 4, 1};
        int len = arr.length;
        int[] temp = new int[arr.length];
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, len - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的终止条件
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        //合并
        merge(arr,left,mid,right,temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        //在temp数组里排序,直到一方排完位置
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //继续
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        //在temp排序完成后再放回原数组arr
        t = 0;
        //int tempLeft = left;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
