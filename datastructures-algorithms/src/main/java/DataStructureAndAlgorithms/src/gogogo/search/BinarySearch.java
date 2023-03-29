package DataStructureAndAlgorithms.src.gogogo.search;

import javafx.beans.binding.When;

/**
 * @author xiaotian
 * @description 搜索算法：搜索的前提是有序
 * @date 2023-03-29 18:56
 */
public class BinarySearch {

    //method1:遍历 o(n)
    //method1: 二分查找 o(logn)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1};
        BinarySearch binarySearch = new BinarySearch();
        int[] res = binarySearch.searchRange(a, 1);
        System.out.println(res);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = 0, right = nums.length - 1;
        int leftIndex = 0, rightIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //向左、向右查找
                leftIndex = rightIndex = mid;
                //防止越界
                while (leftIndex > 0 && nums[leftIndex-1] == target) {
                    leftIndex--;
                }
                //防止越界
                while (rightIndex < nums.length - 1 && nums[rightIndex+1] == target) {
                    rightIndex++;
                }
                return new int[]{leftIndex, rightIndex};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
    //
    //
    //public int[] searchRange(int[] nums, int target) {
    //
    //    int t = binarySearch(nums, target);
    //    if (t == -1) return new int[]{-1, -1};
    //    //向左向右进行查找
    //    int left = t - 1;
    //    int right = t + 1;
    //    while (left >= 0 && nums[left] == target) {
    //        left --;
    //    }
    //    while (right <= nums.length - 1 && nums[right] == target) {
    //        right++;
    //    }
    //    return new int[]{left + 1, right -1 };
    //}
    //
    //private int binarySearch(int[] nums, int target) {
    //    int left = 0, right = nums.length - 1;
    //    int[] ans = new int[2];
    //    int mid;
    //    while (left <= right) {
    //        mid = left + (right - left) / 2;
    //        if (target == nums[mid]) {
    //            return mid;
    //        } else if (target < nums[mid]) {
    //            right = mid - 1;
    //        } else {
    //            left = mid + 1;
    //        }
    //    }
    //    return -1;
    //}