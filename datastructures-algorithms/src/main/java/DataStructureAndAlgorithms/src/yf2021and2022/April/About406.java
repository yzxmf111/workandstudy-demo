package April;

public class About406 {

    /**
     * 时间复杂度O(n^2) 空间复杂度o(1)
     * 最好的方法就是手动在纸上画一画
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int left = 2, right = 2;
        while (right < nums.length) {
            //有序数组必有三个元素相等
            if (nums[left - 2] == nums[right]) {
                right++;
            } else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }

    //双指针进行处理
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums.length;
        //left记录着不重复的元素应该去的位置
        //right记录着不重复的元素位置
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
                right++;
            } else {

                right++;
            }
        }
        return left + 1;
    }

    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        //j奇数的指针
        int j = 1;
        //i 偶数的指针
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 != 0) {
                while (nums[j] % 2 != 0) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
