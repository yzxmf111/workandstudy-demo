package November.ywqz;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaotian
 */
public class FastSortDemo {

    /**
     * 当待排序元素数目小于等于7的时候,使用插入排序
     */
    private static final int INSERT_SORT_THRESHOLD = 7;


    /**
     * 防止排序出现o(n^2)的时间复杂度
     */
    private static final Random RANDOM = new Random();

    private static int[] sortArray(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (right - left < INSERT_SORT_THRESHOLD) {
            insertSort(arr, left, right);
            return;
        }

        int partition = partition(arr, left, right);
        quickSort(arr,left,partition -1);
        quickSort(arr,partition + 1, right);

    }

    private static int partition(int[] arr, int left, int right) {

        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        //为了防止出现数组有序或者无序的情况
        swap(arr, left, randomIndex);
        // 基准值
        int pivot = arr[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                lt++;
                swap(arr,lt,i);
            }
        }
        //确定了一个元素的位置
        swap(arr,left,lt);
        return lt;
    }

    private static void swap(int[] arr, int lt, int i) {
        int temp = arr[lt];
        arr[lt] = arr[i];
        arr[i] = temp;
    }

    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = {4,5,8,7,11,28,5,3};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }


}
