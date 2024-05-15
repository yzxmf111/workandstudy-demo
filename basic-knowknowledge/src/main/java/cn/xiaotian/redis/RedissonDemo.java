package cn.xiaotian.redis;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaotian
 * @description redisson demo
 * @date 2024-05-03 23:47
 */
public class RedissonDemo {

    public static void main(String[] args) {
//         Config config = new Config();
//         config.useSingleServer()
//                 .setAddress("redis://127.0.0.1:6379")
//                 .setPassword("123456")
//                 .setDatabase(0);
//         RedissonClient redissonClient = Redisson.create(config);
// //获取锁对象实例
//         final String lockKey = "abc";
//         RLock rLock = redissonClient.getLock(lockKey);
//
//         try {
//             //尝试5秒内获取锁，如果获取到了，最长60秒自动释放
//             boolean res = rLock.tryLock(5L, 60L, TimeUnit.SECONDS);
//             if (res) {
//                 //成功获得锁，在这里处理业务
//                 System.out.println("获取锁成功");
//             }
//         } catch (Exception e) {
//             System.out.println("获取锁失败，失败原因：" + e.getMessage());
//         } finally {
//             //无论如何, 最后都要解锁
//             rLock.unlock();
//         }
//
// //关闭客户端
//         redissonClient.shutdown();

        // 创建一个 Redisson 客户端实例
        RedissonClient redissonClient = Redisson.create();
        // 获取一个名为 "javaguide.limiter" 的限流器对象
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("javaguide.limiter");
        // 尝试设置限流器的速率为每小时 100 次
        // RateType 有两种，OVERALL是全局限流,ER_CLIENT是单Client限流（可以认为就是单机限流）
        rateLimiter.trySetRate(RateType.OVERALL, 100, 1, RateIntervalUnit.HOURS);

    }
}
