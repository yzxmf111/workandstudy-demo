package cn.xiaotian.limit_flow_and_degrade;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author xiaotian
 * @description 限流实现
 * @date 2023-03-23 17:08
 */
public class LimitFlow {

    public static void main(String[] args) {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get 1 tokens: %ss%n", sleepingTime);
        }
    }
}



