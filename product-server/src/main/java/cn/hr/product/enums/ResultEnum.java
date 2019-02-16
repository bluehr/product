package cn.hr.product.enums;

import lombok.Getter;

/**
 * @author fys2000
 * @date 2019/1/29 10:36
 * @description
 */
@Getter
public enum ResultEnum {
    /**
     *
     */
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
