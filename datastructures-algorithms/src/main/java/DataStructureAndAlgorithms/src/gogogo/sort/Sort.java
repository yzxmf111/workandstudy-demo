package DataStructureAndAlgorithms.src.gogogo.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {3,2,1,2,54,22,6,3,4,213,432,123,23434,123,2};
        Sort sort = new Sort();
        int[] ints = sort.bubbleSort(nums);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(ints) + "time:" + (end - start));
    }

    public int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2 ) return new int[]{};
        int j = nums.length, temp;
        //优化
        Boolean flag = false;
        for (int e = 0; e < nums.length - 1; e++) {
            for (int i = 0; i < j - 1 - e; i++) {
                if (nums[i] > nums[i + 1]) {
                    temp =  nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return nums;
    }
}
