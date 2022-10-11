package November.ZS;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {4, 3, 5, 6, 2, 1};
        int[] nums = bubbleSort(arr);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int[] bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return arr;
    }
}
