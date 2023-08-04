package io.github.alexKitC.common.exception;

/**
 * @author alex
 * @version 1.0.0
 * @apiNote 统一的业务异常
 * @since 2023-08-04 10:44
 */
public class BizException extends RuntimeException {
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BizException(String message) {
        this.message = message;
    }

    public BizException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
