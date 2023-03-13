package gogogo;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author xiaotian
 * @description 最大子数组和
 * @date 2023-02-28 15:54
 */
public class D230228 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int i : dp) {
            if(max < i) {
                max = i;
            }
        }
        //for (int i = 0; i < dp.length; i++) {
        //    if (dp[i] < 0)
        //}
        return max;
    //    //int[] dp = new int[nums.length];
    //    //dp[0] = nums[0];
    //    int max = nums[0], submax = nums[0];
    //    for (int i = 1; i < nums.length; i++) {
    //        submax = Math.max(submax + nums[i], nums[i]);
    //        max = Math.max(max, submax);
    //    }
    //    //for (int i : dp) {
    //    //    if (max < i) {
    //    //        max = i;
    //    //    }
    //    //}
    //    return max;
    //}

    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 1};
        D230228 d230228 = new D230228();
        //int i = d230228.maxSubArray(ints);
        int i = d230228.thirdMax(ints);
        System.out.println(i);
        Class<Integer> integerClass = Integer.class;
    }

    //case：{1,2,2,3,4,2}  {1,2,2,2,2}
    public int thirdMax(int[] nums) {
        //treeSet底层：红黑树
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }

//     public int thirdMax(int[] nums) {
//        TreeSet<Integer> s = new TreeSet<Integer>();
//        for (int num : nums) {
//            s.add(num);
//            if (s.size() > 3) {
//                s.remove(s.first());
//            }
//        }
//        return s.size() == 3 ? s.first() : s.last();
//    }
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/third-maximum-number/solutions/1032401/di-san-da-de-shu-by-leetcode-solution-h3sp/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
}
