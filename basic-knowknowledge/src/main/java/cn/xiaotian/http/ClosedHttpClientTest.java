package cn.xiaotian.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-08 13:52
 */
public class ClosedHttpClientTest {

    private static String tokenString = "";
    private static CloseableHttpClient httpClient = null;

    /**
     * 以post方式调用第三方接口
     * @param url
     * @param json
     * @return
     */
    public static String doPost(String url, JSONObject json){

        try {
            if (httpClient == null){
                httpClient = HttpClientBuilder.create().build();
            }

            HttpPost post = new HttpPost(url);

            if (tokenString != null && !tokenString.equals("")){
                //tokenString = getToken();
            }

            //api_gateway_auth_token自定义header头，用于token验证使用
            //post.addHeader("api_gateway_auth_token", tokenString);
            //post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");

            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            s.setContentType("application/x-www-form-urlencoded");
            //设置请求参数
            post.setEntity(s);
            HttpResponse response = httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //返回json格式
                String res = EntityUtils.toString(response.getEntity());
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //String rs = doGet(
        //        "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600");
        //System.out.println(rs);
        //
        JSONObject respObject = new JSONObject();

        if (respObject.get("success") != null && (boolean)respObject.get("success")) {
            System.out.println(respObject);
        }

    }

    //public static String getHttpResult(String url) {
    //    if (httpClient == null){
    //        httpClient = HttpClientBuilder.create().build();
    //    }
    //    HttpGet httpget = new HttpGet(url);
    //    String json = null;
    //    try {
    //        HttpResponse response = httpclient.execute(httpget);
    //        HttpEntity entity = response.getEntity();
    //        if (entity != null) {
    //            json = EntityUtils.toString(entity, "UTF-8").trim();
    //
    //        }
    //    } catch (ClientProtocolException e) {
    //        e.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    } finally {
    //        httpget.abort();
    //    }
    //    return json;
    //
    //}

    public static String doGet(String url) {
        //创建HttpClient对象
        if (httpClient == null){
            httpClient = HttpClientBuilder.create().build();
        }
        HttpGet httpGet = new HttpGet(url);
        if (null != tokenString && !tokenString.equals("")) {
            //tokenString = getToken();
        }
        //api_gateway_auth_token自定义header头，用于token验证使用
        //httpGet.addHeader("api_gateway_auth_token",tokenString);
        //httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //返回json格式
                String res = EntityUtils.toString(response.getEntity());
                return res;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}

