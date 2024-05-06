package study2024;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/6 13:49
 **/
public class D240506 {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}
		Map<Character, Integer> map = new HashMap<>();
		int max = 0, j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s.length() < p.length()) {
			return res;
		}
		//存储
		int[] arrayP = new int[26];
		int[] arrayS = new int[26];
		for (int i = 0; i < p.length(); i++) {
			arrayS[s.charAt(i) - 'a']++;
			arrayP[p.charAt(i) - 'a']++;
		}
		if (Arrays.equals(arrayP, arrayS)) {
			res.add(0);
		}
		//构建窗口
		int left = 0;
		int right = left + p.length() - 1;
		while (true) {
			//滑动
			arrayS[s.charAt(left) - 'a']--;
			left++;
			right++;
			if (right >= s.length()) {
				break;
			}
			arrayS[s.charAt(right) - 'a']++;
			if (Arrays.equals(arrayP, arrayS)) {
				res.add(left);
			}
		}
		return res;
	}
}
