package study2024;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/2/26 10:47
 **/
public class D240226 {

	/**
	 * 字符串解码 32[a2[c]] 2[abc]3[cd]ef 3[be]2[a]
	 * 辅助栈
	 */
	public String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		Deque<Integer> numStack = new ArrayDeque<>();
		Deque<String> charStack = new ArrayDeque<>();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.toCharArray().length; i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = num * 10 + Integer.parseInt(s.charAt(i) + "");
			}
			else if (s.charAt(i) == '[') {
				numStack.addFirst(num);
				charStack.addFirst(sb.toString());
				num = 0;
				sb = new StringBuilder();
			} else if (s.charAt(i) == ']') {
				StringBuilder newSb = new StringBuilder();
				Integer count = numStack.removeFirst();
				for (Integer integer = 0; integer < count; integer++) {
					newSb.append(sb.toString());
				}
				sb = new StringBuilder().append(charStack.removeFirst()).append(newSb.toString());
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
//		 String a = "100[be]";
		D240226 d240226 = new D240226();
//		String s = d240226.decodeString(a);
//		System.out.println(s);
		int[] a = {-1,0,1,2,-1,-4};
		List<List<Integer>> lists = d240226.threeSum(a);
		System.out.println(lists);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		//排序的目的在于去重 key one
		Arrays.sort(nums);
		if (nums[0] > 0) {
			return res;
		}
		//key two
		for (int i = 0; i < nums.length - 2; i++) {
			//key three
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}


}
