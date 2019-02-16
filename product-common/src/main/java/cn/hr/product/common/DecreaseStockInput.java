package cn.hr.product.common;

import lombok.Data;

/**
 * @author fys2000
 * @date 2019/2/15 14:53
 * @description
 */
@Data
public class DecreaseStockInput {
    private String productId;
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
