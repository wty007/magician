package org.terry.magician.api.support;

public class APIResult {

    private Object data = "{}";
    private int code;
    private String message;

    public APIResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public APIResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIResult(int code) {
        this.code = code;
    }

    public static APIResult createSuccess(Object data) {
        return new APIResult(0, "", data);
    }

    public static APIResult createSuccess() {
        return new APIResult(0);
    }

    public static APIResult createInstance() {
        return new APIResult(0);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
