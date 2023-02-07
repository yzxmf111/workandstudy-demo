package cn.xiaotian.json;

/**
 * @author xiaotian
 * @description
 * @date 2023-01-05 14:06
 */
public class QueryParams implements java.io.Serializable {

    private java.lang.String platform;

    private java.lang.String blackBox;

    private java.lang.String tokenId;

    private java.lang.String type;

    private java.lang.String partnerCode;

    private java.lang.String appName;

    private java.lang.String sequenceId;

    private java.lang.String responseType;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBlackBox() {
        return blackBox;
    }

    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}