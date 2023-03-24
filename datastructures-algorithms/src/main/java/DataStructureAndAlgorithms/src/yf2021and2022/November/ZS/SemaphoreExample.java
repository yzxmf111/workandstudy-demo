package November.ZS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SemaphoreExample {

        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length == 0) return false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }
            Set<Integer> set = map.keySet();
            int[] nums = new int[arr.length];
            int a = 0;
            for (Integer i : set) {
                nums[a++] = i;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) return false;
            }
            return true;
        }

}
