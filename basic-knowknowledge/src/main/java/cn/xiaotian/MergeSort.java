package cn.xiaotian;

import org.assertj.core.util.Arrays;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/25 14:30
 **/
public class MergeSort {

	public int[] mergeSort(int[] nums) {
		int[] tmp = new int[nums.length];
		int left = 0, right = nums.length - 1;
		dfs(left, right, nums, tmp);
		return nums;
	}

	private void dfs(int left, int right, int[] nums, int[] tmp) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		dfs(left, mid, nums, tmp);
		dfs(mid + 1, right, nums, tmp);
		if (nums[mid] <= nums[mid+1]) {
			return;
		}
		merge(left, right, mid, nums, tmp);
	}

	private void merge(int left, int right, int mid, int[] nums, int[] tmp) {
		for (int i = left; i <= right; i++) {
			tmp[i] = nums[i];
		}
		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) {
			if (tmp[i] < tmp[j]) {
				nums[k++] = tmp[i++];
			} else {
				nums[k++] = tmp[j++];
			}
		}
		while (i<=mid) {
			nums[k++] = tmp[i++];
		}
		while (j <= right) {
			nums[k++] = tmp[j++];
		}
	}

	public static void main(String[] args) {
		int[] nums = {2,1,3,4};
		int[] res = new MergeSort().mergeSort(nums);
		System.out.println(Arrays.asList(res));
	}
}
