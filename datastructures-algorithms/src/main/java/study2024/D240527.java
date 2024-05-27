package study2024;

import java.util.Arrays;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/27 13:46
 **/
public class D240527 {

	public static void main(String[] args) {
		int[] nums = {120, 32, 23, 43, 12, 33, 1, 231, 24345};
		D240527 d240527 = new D240527();
		int[] res = d240527.quickSort(nums);
		int[] res2 = d240527.mergeSort(nums);
		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(res2));
	}

	/**
	 * 快排
	 *
	 * @param nums
	 * @return
	 */
	public int[] quickSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		sort(0, nums.length - 1, nums);
		return nums;
	}

	private void sort(int left, int right, int[] nums) {
		if (left >= right) {
			return;
		}
		int index = left;
		int basicNum = nums[left];
		for (int i = left + 1; i <= right; i++) {
			if (basicNum > nums[i]) {
				index++;
				swap(nums, i, index);
			}
		}
		swap(nums, index, left);
		sort(left, index - 1, nums);
		sort(index + 1, right, nums);
	}

	private void swap(int[] nums, int i, int index) {
		int tmp = nums[i];
		nums[i] = nums[index];
		nums[index] = tmp;
	}

	public int[] mergeSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		int[] tmp = new int[nums.length];
		divid(0, nums.length - 1, nums, tmp);
		return nums;
	}

	private void divid(int left, int right, int[] nums, int[] tmp) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		divid(left, mid, nums, tmp);
		divid(mid + 1, right, nums, tmp);
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

	/**
	 * 链表中节点数目为 n
	 * 1 <= n <= 500
	 * -500 <= Node.val <= 500
	 * 1 <= left <= right <= n
	 * <p>
	 * 输入：head = [1,2,3,4,5], left = 2, right = 4
	 * 输出：[1,4,3,2,5]
	 *
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode res = pre;
		pre.next = head;
		ListNode start, end = pre, after;
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}
		for (int i = 0; i < right; i++) {
			end = end.next;
		}
		after = end.next;
		end.next = null;
		start = pre.next;
		pre.next = reverse(start);
		start.next = after;
		return res.next;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null, cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	/**
	 * 链表中的节点数目为 n
	 * 1 <= k <= n <= 5000
	 * 0 <= Node.val <= 1000
	 *
	 * 输入：head = [1,2,3,4,5], k = 2
	 * 输出：[2,1,4,3,5]
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode res = pre;
		pre.next = head;
		ListNode start, end = pre, after;
		while (end != null) {
			for (int i = 0; i < k; i++) {
				if (end != null) {
					end = end.next;
				} else {
					break;
				}
			}
			if (end == null) {
				break;
			}

			after = end.next;
			end.next = null;
			start = pre.next;
			pre.next = reverse(start);
			start.next = after;
			pre = start;
			end = start;
		}
		return res.next;
	}

}
