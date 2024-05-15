package study2024;

import gogogo.ListNode;

import java.util.Arrays;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/15 14:58
 **/
public class D240515 {

	public static void main(String[] args) {
		D240515 d240515 = new D240515();
		int[] ints = d240515.mergeSort(new int[]{2, 1, 4, 3, 12, 3, 5, 6, 67, 78, 89, 80, 90, 5, 45, 4, 56});
		System.out.println(Arrays.asList(ints));
	}

	//数组快排
	public int[] quickSort(int[] nums) {
		int len = nums.length;
		sort(0, len - 1, nums);
		return nums;
	}

	private void sort(int left, int right, int[] nums) {
		if (left >= right) {
			return;
		}
		//记录最终交换时的位置
		int sortNumIndex = left;
		//one
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] <= nums[left]) {
				sortNumIndex++;
				swap(i, sortNumIndex, nums);
			}
		}
		swap(sortNumIndex, left, nums);
		sort(left, sortNumIndex - 1, nums);
		sort(sortNumIndex + 1, sortNumIndex, nums);
	}

	private void swap(int sortNumIndex, int left, int[] nums) {
		int tmp = nums[sortNumIndex];
		// nums[left] = tmp;
		nums[sortNumIndex] = nums[left];
		nums[left] = tmp;
	}

	//数组归并排序
	public int[] mergeSort(int[] nums) {
		int len = nums.length;
		int[] tmp = new int[nums.length];
		dfs(0, len - 1, nums, tmp);
		return nums;
	}

	private void dfs(int left, int right, int[] nums, int[] tmp) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		dfs(left, mid, nums, tmp);
		dfs(mid + 1, right, nums, tmp);
		if (nums[mid] < nums[mid + 1]) {
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
		while (i <= mid) {
			nums[k++] = tmp[i++];
		}
		while (j <= right) {
			nums[k++] = tmp[j++];
		}
	}

	//链表归并排序
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return listNodeSort(head);

	}

	private ListNode listNodeSort(ListNode head) {
		//one
		if (head == null || head.next == null) {
			return head;
		}
		//找中点
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow;
		ListNode after = mid.next;
		mid.next = null;
		//先分后合
		ListNode leftNode = listNodeSort(head);
		ListNode rightNode = listNodeSort(after);
		ListNode res = merge(leftNode, rightNode);
		return res;
	}

	/**
	 * 合并两个有序链表
	 * @param first
	 * @param second
	 */
	private ListNode merge(ListNode first, ListNode second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		if (first.val < second.val) {
			first.next = merge(first.next, second);
			return first;
		} else {
			second.next = merge(first, second.next);
			return second;
		}
	}
}

