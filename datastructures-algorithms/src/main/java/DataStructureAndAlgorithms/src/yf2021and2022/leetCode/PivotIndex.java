package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/28 18:18
 */


public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex solution = new PivotIndex();
        int[] arr = {1,7,3,6,5,6};
        int i = solution.pivotIndex(arr);
        System.out.println(i);
    }
    public int pivotIndex(int[] nums) {
        if (nums == null) return -1;
        /*int sumA = 0, sumB = 0;
        //存在大量的重复计算
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                sumA+=nums[k];
            }
            for (int j = nums.length - 1; j > i; j--) {
                sumB +=nums[j];
            }
            if (sumA == sumB) {
                return i;
            } else {
                sumA = 0;
                sumB = 0;
            }
        }
        return -1;*/

        int sumA = 0;
        for (int i = 0; i < nums.length; i++) {
            sumA += nums[i];
        }
        int sumB = 0;
        //不是第一个
//        for (int i = nums.length - 1; i >= 0 ; i--) {
//            sumA -= nums[i];
//            if (sumA == sumB) return i;
//            else {
//                sumB += nums[i];
//            }
//        }

        for (int i = 0; i < nums.length; i++) {
            sumB += nums[i];
            if (sumA == sumB) return i;
            else {
                sumA -= nums[i];
            }
        }
        return -1;
    }
}
