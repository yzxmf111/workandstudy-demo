package November.ZS;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 9, 6};

        System.out.println(Arrays.toString(insertSort(arr)));
    }

    private static int[] insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }

}
