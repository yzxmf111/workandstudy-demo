package study2024;

import java.util.TreeSet;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/19 11:38
 **/
public class D240319 {

	public int thirdMax(int[] nums) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		for (int num : nums) {
			s.add(num);
			if (s.size() > 3) {
				s.remove(s.first());
			}
		}
		return s.size() == 3 ? s.first() : s.last();
	}
}
