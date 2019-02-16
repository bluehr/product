package cn.hr.product.enums;

import lombok.Getter;

/**
 * @Auther: fys2000
 * @Date: 2019/1/18 15:00
 * @Description:
 */
@Getter
public enum  ProductStatusEnum {
    /**
     * 商品在架
     */
    UP(0,"在架"),
    /**
     * 商品下架
     */
    DOWN(1,"下架");

    private Integer code;
    private String status;

    ProductStatusEnum(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

}
