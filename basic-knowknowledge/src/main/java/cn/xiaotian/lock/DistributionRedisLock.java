//package cn.xiaotian.lock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author xiaotian
// * @description  redis实现的分布式锁自动续期
// * @date 2023-04-24 15:10
// */
//public class DistributionRedisLock {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    public Boolean tryLock(String key, String value, long expireTime) {
//        try {
//            //自旋上限
//            int waitCount = 100;
//            while (waitCount > 0) {
//                //SET命令返回OK ，则证明获取锁成功.
//                Boolean setIfAbsent = redisTemplate.opsForValue().set(key, value, "NX", "EX", expireTime);
//                if (setIfAbsent) {
//                    //对共享变量的操作
//                    //增删改库，缓存之类的 需要100s
//                    //。。。。。。。。。。
//                    //续命
//                    Thread demo = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            while (true) {
//                                Boolean expire = redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//                                //有可能已经主动删除key,不需要在续命
//                                if(!expire){
//                                    return;
//                                }
//                                try {
//                                    Thread.sleep(1000);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    });
//                    demo.setDaemon(true);
//                    demo.start();
//                    return true;
//                }
//                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
//                Thread.sleep(3000);
//                waitCount--;
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//        //没设置到锁，即表示超时了
//        return false;
//
//    }
//
//    public Boolean unlock(String key, String value) {
//        //del lock
//        return true;
//    }
//}
