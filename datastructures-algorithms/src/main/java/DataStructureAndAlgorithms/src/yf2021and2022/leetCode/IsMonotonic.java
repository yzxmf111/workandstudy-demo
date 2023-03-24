package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/28 17:23
 */


public class IsMonotonic {

    public static void main(String[] args) {
        IsMonotonic IM = new IsMonotonic();
        int[] a = {1,1,0};
        boolean monotonic = IM.isMonotonic1(a);
        System.out.println(monotonic);
    }

    public boolean isMonotonic1(int[] A) {

        return monotonousOrNot(A, true) || monotonousOrNot(A, false);

    }

    /**
     *
     * @param a
     * @param b true 代表判断该数组是否为单调递增, false 判断是否单调递减
     * @return
     */
    private boolean monotonousOrNot(int[] a, boolean b) {
        if (b) {
            for (int i = 1; i < a.length; i++) {
                if (a[i] < a[i - 1]) return false;
            }
        } else {
            for (int i = 1; i < a.length; i++) {
                if (a[i] > a[i - 1]) return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] A) {

        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; i++) {
            if(A[i] - A[i-1] > 0) {
                dec = false;
            }
            if (A[i] - A[i-1] < 0) {
                inc = false;
            }
        }
        return dec || inc;

    }
}
