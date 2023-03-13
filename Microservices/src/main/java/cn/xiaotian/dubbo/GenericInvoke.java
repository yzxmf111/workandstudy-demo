package cn.xiaotian.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaotian
 * @description dubbo泛化调用
 * @date 2023-03-02 17:19
 */
public class GenericInvoke {

    //定义泛化调用服务类
    private static GenericService genericService;
    public static void main(String[] args) throws Exception {
        //创建ApplicationConfig
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("generic-call-consumer");
        //创建注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        //创建服务引用配置
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        //设置接口
        referenceConfig.setInterface("org.apache.dubbo.samples.generic.call.api.HelloService");
        applicationConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        //重点：设置为泛化调用
        //注：不再推荐使用参数为布尔值的setGeneric函数
        //应该使用referenceConfig.setGeneric("true")代替
        referenceConfig.setGeneric(true);
        //设置异步，不必须，根据业务而定。
        referenceConfig.setAsync(true);
        //设置超时时间
        referenceConfig.setTimeout(7000);

        //获取服务，由于是泛化调用，所以获取的一定是GenericService类型
        genericService = referenceConfig.get();

        //使用GenericService类对象的$invoke方法可以代替原方法使用
        //第一个参数是需要调用的方法名
        //第二个参数是需要调用的方法的参数类型数组，为String数组，里面存入参数的全类名。
        //第三个参数是需要调用的方法的参数数组，为Object数组，里面存入需要的参数。
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"world"});
        //使用CountDownLatch，如果使用同步调用则不需要这么做。
        CountDownLatch latch = new CountDownLatch(1);
        //获取结果 dubbo 2.7.0
        //CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        //future.whenComplete((value, t) -> {
        //    System.err.println("invokeSayHello(whenComplete): " + value);
        //    latch.countDown();
        //});
        ////打印结果
        System.err.println("invokeSayHello(return): " + result);
        latch.await();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        //我们对每个字符串进行排序,相同的放在一个映射中
        for (int i = 0; i < strs.length; i++) {
            char[] char_str = strs[i].toCharArray();
            Arrays.sort(char_str);
            String key = String.valueOf(char_str);//映射
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

}
