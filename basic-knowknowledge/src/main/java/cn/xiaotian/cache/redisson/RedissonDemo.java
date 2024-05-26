package cn.xiaotian.cache.redisson;

import org.apache.commons.collections4.Get;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yzxmf
 * @Date: 2024/05/25/23:19
 * @Description:
 */
public class RedissonDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        // 1. Create config object
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

// or read config from file
        config = Config.fromYAML(new File("config-file.yaml"));
        // 2. Create Redisson instance

// Sync and Async API
        RedissonClient redisson = Redisson.create(config);

// Reactive API
        RedissonReactiveClient redissonReactive = redisson.reactive();

// RxJava3 API
        RedissonRxClient redissonRx = redisson.rxJava();

        // 3. Get Redis based implementation of java.util.concurrent.ConcurrentMap
//        RMap<MyKey, MyValue> map = redisson.getMap("myMap");
//
//        RMapReactive<MyKey, MyValue> mapReactive = redissonReactive.getMap("myMap");
//
//        RMapRx<MyKey, MyValue> mapRx = redissonRx.getMap("myMap");

        // 4. Get Redis based implementation of java.util.concurrent.locks.Lock
//        RLock lock = redisson.getLock("myLock");
//
//        RLockReactive lockReactive = redissonReactive.getLock("myLock");
//
//        RLockRx lockRx = redissonRx.getLock("myLock");
//
//         4. Get Redis based implementation of java.util.concurrent.ExecutorService
        RExecutorService executor = redisson.getExecutorService("myExecutorService");

// over 50 Redis based Java objects and services ...

        RLock lock = redisson.getLock("anyLock");
// 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            try {

            } finally {
                lock.unlock();
            }
        }

    }

}
