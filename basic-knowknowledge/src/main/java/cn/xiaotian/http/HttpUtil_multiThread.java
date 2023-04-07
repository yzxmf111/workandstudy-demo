package cn.xiaotian.http;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author xiaotian
 * @description 考虑到并发和超时问题的http请求
 * @date 2023-04-07 13:42
 */
public class HttpUtil_multiThread {


    public final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final int connectionPoolSize = Runtime.getRuntime().availableProcessors() * 50;
    private static PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

    private static CloseableHttpClient httpClient = null;


    @Value("${poseidon.bodyguard.readTimeOut}")
    private int readTimeOut;
    @Value("${poseidon.bodyguard.connectTimeOut}")
    private int connectTimeOut;

    @PostConstruct
    public void init() {
        // 设置连接池
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小(最大连接数量是由defaultMaxPerRoute决定)
        // 连接池最大数量不能小于线程数最大值，否则会有请求被丢弃的情况
        connMgr.setMaxTotal(connectionPoolSize);
        connMgr.setDefaultMaxPerRoute(connectionPoolSize);

        // 设置请求配置
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(connectTimeOut);
        // 设置读取超时
        configBuilder.setSocketTimeout(readTimeOut);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(500);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        RequestConfig requestConfig = configBuilder.build();
        httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).build();
    }


    /**
     * 发送post表单请求，如果连续n次链接不通，则报异常
     */
    public static String doPostForm(String url, Map<String, String> header, List<BasicNameValuePair> nvps, int reTryCnt) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("utf-8")));

        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                logger.info("调用http接口 url:{} , header：{}， nvps: {} ", url, header, nvps);
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String body = handler.handleResponse(response);
                    logger.debug("调用http接口 url:{} , header：{}， nvps: {} ,返回body:{}", url, header, nvps, body);
                    return body;
                } else {
                    logger.info("调用http接口 第 {} 次 访问url {} 失败！, header：{}， nvps: {}, getStatusCode:{}", i, url, header,
                            nvps, response.getStatusLine().getStatusCode());
                }
            } catch (Exception e) {
                logger.warn("调用http接口异常, {}", e.getMessage());
            } finally {
                try {
                    if (response != null) {
                        response.close();
                    }
                } catch (Exception e2) {
                }
            }
        }
        logger.error("调用http接口异常,主机 {} 尝试{}次均不能连接，请检查主机服务状态！", url, reTryCnt);
        return null;
    }
}
