package study2024;

import gogogo.ListNode;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/22 16:31
 **/
public class D240322 {




	/**
	 * 数组归并排序：空间复杂度：O(n + logn) 时间复杂度 ：每层都要排序 X 层数 o(n) * o(logn)
	 */
	public int[] mergeSort(int[] nums) {
		if (nums == null) {
			return new int[]{};
		}
		int left = 0, right = nums.length - 1;
		int[] temp = new int[nums.length];
		mergeSort(left, right, temp, nums);
		return nums;
	}

	private void mergeSort(int left, int right, int[] temp, int[] nums) {
		if (left >= right) {
			return;
		}
		// int mid = left + (right - left) / 2;
		int mid = (right + left) >>> 1;
		mergeSort(left, mid, temp, nums);
		mergeSort(mid + 1, right, temp, nums);
		merge(left, mid, right, temp, nums);
	}

	private void merge(int left, int mid, int right, int[] temp, int[] nums) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = nums[i];
		}
		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) {
			if (temp[i] < temp[j]) {
				nums[k++] = temp[i++];
			} else {
				nums[k++] = temp[j++];
			}
		}
		//左半部未加完
		while (i <= mid) {
			nums[k++] = temp[i++];
		}
		//右半部未加完
		while (j <= right) {
			nums[k++] = temp[j++];
		}
	}


	/**
	 * 链表排序：要求O(n log n) 时间复杂度和常数级空间复杂度下
	 * 归并排序可以满足O(n log n) 时间复杂度。
	 * 分治：分到不可再分再合并：合并两个有序链表
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		return sort(head);
	}

	private ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode left = sort(head);
		ListNode right = sort(mid);
		return mergeListNode(left, right);
	}

	private ListNode mergeListNode(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode res = pre;
		while (left != null && right != null) {
			if (left.val < right.val) {
				pre.next = left;
				left = left.next;
			} else {
				pre.next = right;
				right = right.next;
			}
			pre = pre.next;
		}
		if (left == null) {
			pre.next = right;
		}
		if (right == null) {
			pre.next = left;
		}
		return res.next;
	}
}
