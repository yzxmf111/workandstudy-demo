package study2024;

import java.util.Arrays;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/15 10:03
 **/
public class D240315 {

	public int minMoves(int[] nums) {
		long sum = 0l;
		int min = Arrays.stream(nums).min().getAsInt();
		for (int num : nums) {
			sum += num;
		}
		return (int) (sum - nums.length * min);

	}

	public int minMoves2(int[] nums) {
		long sum = 0, min = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			sum += num;
		}
		return (int) (sum - nums.length * min);
	}

	public static void main(String[] args) {
		D240315 d240315 = new D240315();
		int i = d240315.minMoves2(new int[]{1, 2, 3});
		System.out.println(i);
	}
}
