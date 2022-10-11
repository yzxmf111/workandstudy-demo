package November.future;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 2, 66, 23};
        //递归算法 肯定是要有左右边界的
        MergeSort ms = new MergeSort();
        int[] temp = new int[arr.length];
        ms.mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //
    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        //递归的分分分分 , 递归的和和和和  --终止条件,递归到只有一个元素的时候
        if (left >= right) return;
        int mid = left + (right - left) / 2; //防止整型溢出
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        mergeTwoSortedArray(arr, left, mid, right, temp);
    }

    //在一个临时数组里边进行排序
    private void mergeTwoSortedArray(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;
        //直到左边或者右边排序完成
        while (i <= mid && j <= right) {//继续
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //继续赋值
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //将排好序的部分数组拷贝回arr
        t = 0;
        //int tempLeft = left;
        while (left <= right) {
            arr[left] = temp[t];
            left++;
            t++;
        }
    }
}

