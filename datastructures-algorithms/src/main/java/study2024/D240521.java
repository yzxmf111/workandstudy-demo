package study2024;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/21 15:10
 **/
public class D240521 {
	/**
	 * 滑动窗口最大值
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		//存的是数组的的索引
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			if (i - deque.peekFirst() - k >= 0) {
				deque.removeFirst();
			}
			if (i - k + 1 >= 0 ) {
				res[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		return res;
	}


	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。  {0,1,0,3,12}
	 * 1 <= nums.length <= 104
	 * -231 <= nums[i] <= 231 - 1
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0 ) {
				nums[j++] = nums[i];
			}
		}
		for (int k = j; k < nums.length; k++) {
			nums[k] = 0;
		}
	}

	public void moveZeroes2(int[] nums) {
		if(nums==null) {
			return;
		}
		//两个指针i和j
		int j = 0;
		for(int i=0;i<nums.length;i++) {
			//当前元素!=0，就把其交换到左边，等于0的交换到右边
			if(nums[i]!=0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}
		}
	}


	private void swap(int left, int right, int[] nums) {
		int tmp = nums[right];
		nums[right] = nums[left];
		nums[left] = tmp;
	}

	/**
	 * 滑动窗口
	 * m == s.length
	 * n == t.length
	 * 1 <= m, n <= 105
	 * s 和 t 由英文字母组成
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapT = new HashMap<>();
		int cnt = 0;//代表s的子串含有t字符的数量
		int min = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < t.length(); i++) {
			mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
		}
		for (int left = 0, right = 0; right < s.length(); right++) {
			mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0)+1);
			if (mapT.containsKey(s.charAt(right))) {
				if (mapT.get(s.charAt(right)) >= mapS.get(s.charAt(right))) {
					cnt++;
				}
			}
			while (left < right && (!mapT.containsKey(s.charAt(left)) || mapS.get(s.charAt(left)) > mapT.get(s.charAt(left) ))) {
				mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
				left++;
			}

			if(cnt == t.length() && right - left + 1 < min) {
				min = right - left + 1;
				res = s.substring(left, right + 1);
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// int[] nums = new int[]{0,1,0,3,12};
		D240521 d240521 = new D240521();
		// int[] ints = d240521.maxSlidingWindow(nums, 3);
		// System.out.println(Collections.singletonList(ints));
		// d240521.moveZeroes2(nums);

		String s = "ADOBECODEBANC";
		String t = "ABC";
		String s1 = d240521.minWindow(s, t);
		System.out.println(s1);
	}
}
