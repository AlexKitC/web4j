package io.github.alexKitC.common.resp;

import java.io.Serializable;

/**
 * @author alex
 * @version 1.0.0
 * @apiNote 统一的返回值
 * @since 2023-08-04 10:22
 */
public class R<T> implements Serializable {
    // 返回消息
    private String message;
    // 返回code
    private Integer code;
    // 返回状态
    private Boolean status;
    // 返回的数据
    private T data;


    /**
     * @return R
     * @apiNote 无数据成功返回
     */
    public static R<Void> ok() {
        R<Void> r = new R<>();
        r.setStatus(true);
        r.setMessage(RCodeEnum.SUCCESS.getMessage());
        r.setCode(RCodeEnum.SUCCESS.getCode());
        return r;
    }

    /**
     * @param data 数据
     * @param <T>  返回数据类型
     * @return R
     * @apiNote 带数据成功返回
     */
    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setStatus(true);
        r.setMessage(RCodeEnum.SUCCESS.getMessage());
        r.setCode(RCodeEnum.SUCCESS.getCode());
        r.setData(data);
        return r;
    }

    /**
     * @param data    数据
     * @param message 消息
     * @param <T>     数据类型
     * @return R
     * @apiNote 带数据和消息成功返回
     */
    public static <T> R<T> ok(T data, String message) {
        R<T> r = new R<>();
        r.setStatus(true);
        r.setMessage(message);
        r.setCode(RCodeEnum.SUCCESS.getCode());
        r.setData(data);
        return r;
    }

    /**
     * @return R
     * @apiNote 失败的返回
     */
    public static R<Void> fail() {
        R<Void> r = new R<>();
        r.setStatus(false);
        r.setMessage(RCodeEnum.FAILURE.getMessage());
        r.setCode(RCodeEnum.FAILURE.getCode());
        return r;
    }

    /**
     * @param message 消息
     * @return R
     * @apiNote 带消息的失败返回
     */
    public static R<Void> fail(String message) {
        R<Void> r = new R<>();
        r.setStatus(false);
        r.setMessage(message);
        r.setCode(RCodeEnum.FAILURE.getCode());
        return r;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
