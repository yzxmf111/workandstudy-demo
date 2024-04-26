package study2024;

import org.assertj.core.util.Arrays;

/**
 * @Author yifan.tian
 * @Description 排序
 * @Date 2024/4/25 18:39
 **/
public class D240426 {

	/**
	 * 减治思想
	 * @param nums
	 * @return
	 */
	public int[] quickSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	private void sort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIndex = left;
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] <= nums[pivotIndex]) {
				pivotIndex++;
				swap(nums, i, pivotIndex);
			}
		}
		swap(nums, pivotIndex, left);
		sort(nums, left, pivotIndex - 1);
		sort(nums, pivotIndex + 1, right);

	}

	private void swap(int[] nums, int i, int pivotIndex) {
		int tmp = nums[i];
		nums[i] = nums[pivotIndex];
		nums[pivotIndex] = tmp;
	}


	/**
	 * 分治思想
	 * @param nums
	 * @return
	 */
	public int[] mergeSort(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		int[] nums = {2,1,4,3,1};
		int[] ints = new D240426().quickSort(nums);
		System.out.println(Arrays.asList(ints));
	}


}
