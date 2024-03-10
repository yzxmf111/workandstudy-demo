package cn.xiaotian.http;

import cn.xiaotian.concurrency.multi_thread.AsyncUtil;
import lombok.SneakyThrows;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-08 16:37
 */
public class ConnectPoolTest {

    private static final Logger logegr = LoggerFactory.getLogger(ConnectPoolTest.class);

    private static PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    private static CloseableHttpClient httpClient = null;
    private static final int connectionPoolSize = Runtime.getRuntime().availableProcessors() * 100;


    //private static CloseableHttpClient httpClient = HttpClients.createDefault();

    static {
        // 设置整个连接池最大连接数
        connectionManager.setMaxTotal(500);
        //maxPerRoute意思是某一个服务每次能并行接收的请求数量 https://blog.csdn.net/u013905744/article/details/94714696
        connectionManager.setDefaultMaxPerRoute(100);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(RequestConfig.custom().build())
                .build();
    }


    public static String doGet(String restUrl) {
        HttpGet httpGet = new HttpGet(restUrl);
        httpGet.setHeader("Content-type", "application/json");
        String responseBody = null;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response != null && response.getEntity() != null) {
                responseBody = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e1) {
            logegr.error("【HttpUtil】-doGet-ClientProtocolException-" + e1.getMessage());
        } catch (IOException e1) {
            logegr.error("【HttpUtil】-doGet-IOException-" + e1.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logegr.error("【HttpUtil】-doGet-response.close()-IOException" + e.getMessage());
                }
            }
        }
        return responseBody;

    }
    public static void testPool() {
        int c = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(c);

        //ExecutorService executorService = Executors.newFixedThreadPool(c);

        try {
            for (int i = 1; i <= c; i++) {
                AsyncUtil.execute(new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("=========" + Thread.currentThread().getId());
                        testReq();
                    }
                });
                countDownLatch.countDown();
            }
            //executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AsyncUtil.shutdown();
        }
    }

    private static void testReq() {
        Long startTime = System.currentTimeMillis();
        String result = ConnectPoolTest.doGet("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600");
        Long endTime = System.currentTimeMillis();
        System.out.println("时间：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        testPool();
    }

}
