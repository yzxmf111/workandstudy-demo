package cn.xiaotian.json;

import java.io.Serializable;

/**
 * @author xiaotian
 * @description
 * @date 2023-01-05 14:14
 */
public class BaseResult<T> implements Serializable {

    private boolean success = true;

    private String code = "000";

    private String msg;

    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}