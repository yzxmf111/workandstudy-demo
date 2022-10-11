package November.ZS;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 9, 4, 6};
        //Arrays.sort(arr);
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> list = binarySearch.binarySearch(arr, 1);
        System.out.println(list);
    }

    private List<Integer> binarySearch(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        int mid;
        int temp = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                list.add(mid);
                temp = mid;
                //查到元素之后,继续向左+向右查看是否还有重复的元素
                while (temp + 1 <= right && arr[++temp] == target) {
                    list.add(temp);
                }
                temp = mid;
                while (temp - 1 >= left && arr[--temp] == target) {
                    list.add(temp);
                }
                return list;
            } else if (arr[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return new ArrayList<>();
    }
}
