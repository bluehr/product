package cn.hr.product.exception;

import cn.hr.product.enums.ResultEnum;
import lombok.Getter;

/**
 * @author fys2000
 * @date 2019/1/29 10:55
 * @description
 */
@Getter
public class ProductException extends RuntimeException {
    private Integer code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
