package November.XC;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 9, 6};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //这个元素向前面插入
            int j = i;
            int temp = arr[i];
            //j > 0
            while (j > 0 && arr[j - 1] > temp) {
                arr[j ] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }

        }
    }
}
