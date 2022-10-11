package January.leetCode;

/**
 * @description: 二分查找,关键在于注意等号是否成立,可以使用特例进行判断
 * @author: Tian
 * @time: 2021/1/26 22:43
 */

public class BinarySearch {

    /***
     * 查找的数组为有序数组
     * @param array
     * @param target
     * @return
     */
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        //等号的存在可以让我们查到所有的元素
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1 ;
            }
        }
        return -1;
    }
}
