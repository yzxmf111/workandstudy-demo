package November.future;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3 ,1, 6, 4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        //int t = 1;

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i ;
            while ( j > 0 && arr[j - 1] > temp ) {
                arr[j ] = arr[j - 1];

                j--;
            }
            if (j != i ) {
                arr[j] = temp;
            }
        }
    }
}
