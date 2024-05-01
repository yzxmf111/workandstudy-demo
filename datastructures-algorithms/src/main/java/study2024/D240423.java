package study2024;

/**
 * @Author: yzxmf
 * @Date: 2024/04/23/22:07
 * @Description:
 */
public class D240423 {
    public int maxArea2(int[] height) {
        int max = 0, subMax = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                subMax = Math.min(height[i], height[j]) * (j - i);
                max =  Math.max(subMax, max);
            }
        }
        return max;
    }
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int subMax = 0, max = 0;
        while (left < right) {
            subMax = height[left] < height[right] ? (right - left) * height[left++] :
                    (right - left) * height[right--];
            max = Math.max(subMax, max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        D240423 d240423 = new D240423();
        int i = d240423.maxArea(nums);
        System.out.println(i);
    }
}
