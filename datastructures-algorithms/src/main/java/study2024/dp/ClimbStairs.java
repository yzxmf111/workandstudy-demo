package study2024.dp;

/**
 * @author xiaotian
 * @description
 * @date 2024-03-30 17:30
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int sum = 0, a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


}
