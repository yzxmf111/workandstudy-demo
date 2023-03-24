package March;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/5 21:08
 */


public class BinarySearch {


    public static void main(String[] args) {
        BinarySearch ans = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6};
       // boolean b = ans.binanrSearch1(arr, 4);
        //System.out.println(b);
    }

    private int binanrSearch1(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int[] binarySearch2(int[] arr, int target) {
        if (arr[0] > target || arr[arr.length - 1] < target) return new int[]{-1, -1};
        int ans = binanrSearch1(arr, target);
        if (ans == -1) return new int[]{-1, -1};
        int t = ans;
        while (ans > 0 && arr[ans - 1] == arr[ans]) {
            ans--;
        }

        while (t <= arr.length - 1 && arr[t + 1] == arr[t]) {
            t++;
        }
        return new int[]{ans,t};
    }
}

