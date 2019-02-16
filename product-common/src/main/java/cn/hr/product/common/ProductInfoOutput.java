package cn.hr.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author fys2000
 * @date 2019/2/15 14:57
 * @description
 */
@Data
public class ProductInfoOutput {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType;
}
