package study2024;

import gogogo.ListNode;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/14 14:25
 **/
public class D240514 {
	/**
	 * 优美子数组-滑动窗口
	 */
	public int numberOfSubarraysBest(int[] nums, int k) {
		int left = 0, right = 0, res = 0, target = 0, len = nums.length;
		while (right < len) {
			if (nums[right++] % 2 == 1) {
				target++;
			}
			if (target == k) {
				// int tmpIndex = right;
				int evenNums = 0;
				//判断直到遇到新的奇数前偶数的个数
				while (right < len && nums[right] % 2 == 0) {
					right++;
					evenNums++;
				}
				int oddNums = 0;
				// int tmpIndex = left;
				//判断第一个奇数前边偶数的个数
				while (nums[left] % 2 == 0) {
					left++;
					oddNums++;
				}
				res += (evenNums + 1) * (oddNums + 1);

				left++;
				target--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		D240514 d240514 = new D240514();
		int i = d240514.numberOfSubarraysBest(new int[]{45627,50891,94884,11286,35337,46414,62029,20247,72789,89158,54203,79628,25920,16832,47469,80909}, 1);
		System.out.println(i);

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(3);
		ListNode three = new ListNode(5);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		// ListNode listNode = d240514.alterListNode(one);
		ListNode listNode = d240514.oddEvenList(one);
		System.out.println(listNode);
	}


	public ListNode alterListNode (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddPre = new ListNode(Integer.MIN_VALUE);
		ListNode evenPre = new ListNode(Integer.MIN_VALUE);
		ListNode evenStart = null;
		int count = 0;
		ListNode res = oddPre;
		while (head != null) {
			if (head.val % 2 == 1) {
				oddPre.next = head;
				oddPre = oddPre.next;
			} else {
				count++;
				if (count == 1) {
					evenStart = head;
				}
				evenPre.next = head;
				evenPre = evenPre.next;
			}
			head = head.next;
		}
		oddPre.next = evenStart;
		return res.next;
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int index = 1;
		ListNode oddPre = new ListNode(Integer.MIN_VALUE);
		ListNode evenPre = new ListNode(Integer.MIN_VALUE);
		ListNode start = oddPre;
		ListNode end = evenPre;
		int count = 0;
		while (head != null) {
			if (index % 2 == 1) {
				oddPre.next = head;
				oddPre = oddPre.next;
			} else {
				count++;
				if (count == 1) {
					end = head;
				}
				evenPre.next = head;
				evenPre = evenPre.next;
			}
			index++;
			head = head.next;
		}
		evenPre.next = null;
		oddPre.next = end;
		return start.next;
	}

	public ListNode oddEvenListBest(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		while (evenNode != null && evenNode.next != null) {
			oddNode.next = evenNode.next;
			oddNode = oddNode.next;
			evenNode.next = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = evenNode;
		return head;
	}
}
