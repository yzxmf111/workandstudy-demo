package December.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。
 * 因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
 */
public class FastSort {
    public static void main(String[] args) {
        FastSort fast = new FastSort();
        Long start = System.currentTimeMillis();
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = (int)(Math.random() * 10 *10 * 10000);
        }
        Long end = System.currentTimeMillis();

        fast.fastSort(arr,0,arr.length -1);
        System.out.print(Arrays.toString(arr)  );
        System.out.println((end - start) + " ms");
    }

    static final int INSERT_THRESHOLD = 7;
    static final Random RANDOM = new Random();

    //通过排定一个元素，并且在排定这个元素的同时，对整个数组也做了一次划分。这个过程叫做切分。
    public void fastSort(int[] arr, int left, int right) {
        if (arr.length < 7) {
            insertSort(arr, left, right);
            return;
        }

        //排好一个元素的位置, 递归的向左,向右处理事情---这个元素就是切分点
        int partition = partition(arr, left, right);
        fastSort(arr, left, partition - 1);
        fastSort(arr, partition - 1, right);
    }

    /**
     * 我们的处理办法就是大放过,小交换, 最终在进行一次交换即可
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {

        int index = RANDOM.nextInt(right - left + 1) + left;
        swap(arr,left,index);
        int pivot = arr[left];
        int lt = left; //第 1 部分（小于切分元素的部分）的最后 1 个位置的元素
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                lt++;
                swap(arr, i, lt); //??? 存在问题
            }
        }
        swap(arr, lt, pivot);
        return lt;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > left && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }
}
