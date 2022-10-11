package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/26 21:30
 */


public class Solution05 {

    public static void main(String[] args) {
        Solution05 s = new Solution05();
        int i = s.reverseBits(43261596);
        System.out.println(i);
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int cur = n & 1;
            ans = ans + (cur << (31 - i));
            n >>= 1;
        }

        return ans;
    }
}
