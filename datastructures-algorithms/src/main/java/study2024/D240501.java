package study2024;

/**
 * @author xiaotian
 * @description 接雨水
 * @date 2024-05-01 23:26
 */
public class D240501 {
    /**
     * 前缀最大值+后缀最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = height[0];
        post[n - 1] = height[n - 1];
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            post[i] = Math.max(post[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            sum += Math.min(pre[i], post[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new D240501().trap(a);
        System.out.println(trap);
    }
}
