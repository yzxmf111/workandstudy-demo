package cn.xiaotian.json;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-29 16:59
 */
public class JsonTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        if (jsonObject.getJSONObject("data") != null) {
            System.out.println("111");
        } else {
            System.out.println("222");
        }
    }
}
