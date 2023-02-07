package cn.xiaotian.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author xiaotian
 * @description
 * @date 2023-01-05 14:06
 */
public class BuildJsonOBJ {



    private JSONObject queryFpDeviceInfo(QueryParams params){
        DeviceInfoQuery deviceInfoQuery = new DeviceInfoQuery();
        BaseResult<DeviceResp> baseResult = deviceInfoQuery.query(new QueryParams());
        JSONObject jsonResult;
        if (baseResult.isSuccess()) {
            DeviceResp deviceResp = baseResult.getResult();
            JSONObject respObject = new JSONObject();
            respObject.put("fileType", deviceResp.getFileType());
            respObject.put("whiteList", deviceResp.getWhiteList());
            respObject.put("blackList", deviceResp.getBlackList());

            jsonResult = (JSONObject) JSON.toJSON(baseResult);
            jsonResult.put("result", deviceResp.getDeviceMap());
            jsonResult.put("deviceResp", respObject);
        } else {
            jsonResult = new JSONObject(true);
            jsonResult.put("code", baseResult.getCode());
            jsonResult.put("desc", baseResult.getMsg());
        }
        return jsonResult;
    }


    public static void main(String[] args) {
        String s = "\n" +
                "{\n" +
                "    \"msg\": null,\n" +
                "    \"result\": {\n" +
                "        ...\n" +
                "    },\n" +
                "    \"code\": \"000\",\n" +
                "    \"success\": true,\n" +
                "    \"deviceResp\": {\n" +
                "        \"blackList\": null,\n" +
                "        \"whiteList\": [\"version\", \"tokenId\", \"deviceId\", \"browser\", \"browserType\", \"browserVersion\", \"canvas\", \"cookieEnabled\", \"deviceType\", \"flashEnabled\", \"fontId\", \"languageRes\", \"os\", \"pluginList\", \"referer\", \"screenRes\", \"smartId\", \"tcpOs\", \"trueIp\", \"geoIp\", \"userAgent\"],\n" +
                "        \"fileType\": 1\n" +
                "    }\n" +
                "}";

    }
}
