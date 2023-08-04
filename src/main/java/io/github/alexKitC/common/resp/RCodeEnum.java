package io.github.alexKitC.common.resp;

/**
 * @author alex
 * @version 1.0.0
 * @apiNote 统一返回值的code定义
 * @since 2023-08-04 10:30
 */
public enum RCodeEnum {

    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),
    ;

    private final Integer code;
    private final String message;

    RCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
