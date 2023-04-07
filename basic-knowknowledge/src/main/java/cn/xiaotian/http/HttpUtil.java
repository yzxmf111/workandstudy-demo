package cn.xiaotian.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author xiaotian
 * @description 此工具类具有重试功能，但是没考虑到并发和超时等。
 * @date 2023-04-06 14:50
 */
public class HttpUtil {


    public final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * 发送get请求，默认如果连续3次链接不通，则报异常
     *
     * @param url
     * @param header
     * @return
     */
    public static String doGet(String url, Map<String, String> header) {
        return doGet(url, header, 3);
    }

    /**
     * 发送get请求，如果连续n次链接不通，则报异常
     *
     * @param url 请求地址
     * @param header header信息,map
     * @return 应答的Body内容
     */
    public static String doGet(String url, Map<String, String> header, int reTryCnt) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpget.
        HttpGet httpget = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();
        httpget.setConfig(requestConfig);
        // 设置header信息
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpget.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                logger.info("调用http接口 url:{} , header: {}  ", url, header);
                // 执行get请求.
                response = httpclient.execute(httpget);
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String body = handler.handleResponse(response);
                    // logger.debug("调用http接口 url:{} , header: {} ,返回{} ", url, header, body);
                    return body;
                } else {
                    logger.info("调用http接口 第 {} 次 访问url {} ,header: {} 失败！getStatusCode:{}", i, url, header,
                            response.getStatusLine().getStatusCode());
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
        logger.error("调用http接口异常,url {} 尝试{}次均不能连接，请检查主机服务状态！header:{}", url, reTryCnt, header);
        return null;
    }

    /**
     * 发送post表单请求，默认连续3次链接不通，则报异常
     */
    public static String doPostForm(String url, Map<String, String> header, List<NameValuePair> nvps) {
        return doPostForm(url, header, nvps, 3);
    }

    /**
     * 发送post表单请求，如果连续n次链接不通，则报异常
     */
    public static String doPostForm(String url, Map<String, String> header, List<NameValuePair> nvps, int reTryCnt) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        // 设置header信息
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("utf-8")));

        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                logger.info("调用http接口 url:{} , header：{}， nvps: {} ", url, header, nvps);
                response = httpclient.execute(httpPost);
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

    /**
     * 发送json请求，默认连续3次链接不通，则报异常
     */
    public static String doPostJson(String url, Map<String, String> header, String json) {
        return doPostJson(url, header, json, 3);
    }

    /**
     * 发送json请求，如果连续n次链接不通，则报异常
     */
    public static String doPostJson(String url, Map<String, String> header, String content, int reTryCnt) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        // 设置header信息
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                StringEntity se = new StringEntity(content, Charset.forName("UTF-8"));
                httpPost.setEntity(se);

                logger.info("调用http接口 url:{} , header：{}", url, header);
                response = httpclient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String body = handler.handleResponse(response);
                    logger.debug("调用http接口 url:{} , header：{}， post content: {},返回body{} ", url, header, content, body);
                    return body;
                } else {
                    logger.info("调用http接口 第 {} 次 访问url {} 失败！, header：{}， getStatusCode:{}", i, url, header,
                            response.getStatusLine().getStatusCode());
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

    /**
     * 发送json请求，如果连续n次链接不通，则报异常
     */
    public static String doPostJson(CloseableHttpClient httpClient, String url, String content, int reTryCnt) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                StringEntity se = new StringEntity(content, Charset.forName("UTF-8"));
                httpPost.setEntity(se);

                logger.info("调用http接口 url:{} ", url);
                response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String body = handler.handleResponse(response);
                    logger.debug("调用http接口 url:{} ， post content: {},返回body{} ", url, content, body);
                    return body;
                } else {
                    logger.info("调用http接口 第 {} 次 访问url {} 失败！， getStatusCode:{}", i, url,
                            response.getStatusLine().getStatusCode());
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

    /**
     * 发送get请求，如果连续n次链接不通，则报异常
     *
     * @param url 请求地址
     * @return 应答的Body内容
     */
    public static String doGet(CloseableHttpClient httpClient, String url, int reTryCnt) {
        // 创建httpget.
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        if (reTryCnt < 1) {
            reTryCnt = 1;
        }
        for (int i = 0; i < reTryCnt; i++) {
            try {
                logger.info("调用http接口 url:{}", url);
                // 执行get请求.
                response = httpClient.execute(httpget);
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String body = handler.handleResponse(response);
                    return body;
                } else {
                    logger.info("调用http接口 第 {} 次 访问url {} 失败！getStatusCode:{}", i, url,
                            response.getStatusLine().getStatusCode());
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
        logger.error("调用http接口异常,url {} 尝试{}次均不能连接，请检查主机服务状态！header:{}", url, reTryCnt);
        return null;
    }

}
