package cn.xiaotian.api;

import java.io.Serializable;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/12 18:41
 **/

public class ResponseVO<T> implements Serializable {
    private String msg;
    private Integer code;
    private boolean success;
    private T data;

    protected ResponseVO(final boolean success, final Integer code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public static <T> ResponseVO<T> ok(T data) {
        return new ResponseVO(true, 200, (String)null, data);
    }

    public static ResponseVO fail(Integer errorCode, String msg) {
        return new ResponseVO(false, errorCode, msg, (Object)null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
