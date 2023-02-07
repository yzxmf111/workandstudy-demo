package cn.xiaotian.json;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2023-01-05 14:14
 */
public class DeviceResp implements Serializable {
    Map<String,Object> deviceMap;
    String[] whiteList;
    String[] blackList;
    int fileType;

    public Map<String, Object> getDeviceMap() {
        return deviceMap;
    }

    public void setDeviceMap(Map<String, Object> deviceMap) {
        this.deviceMap = deviceMap;
    }

    public String[] getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String[] whiteList) {
        this.whiteList = whiteList;
    }

    public String[] getBlackList() {
        return blackList;
    }

    public void setBlackList(String[] blackList) {
        this.blackList = blackList;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
}
