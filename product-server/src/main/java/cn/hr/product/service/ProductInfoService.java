package cn.hr.product.service;

import cn.hr.product.entity.ProductInfo;
import cn.hr.product.entity.dto.CartDTO;

import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/18 15:07
 * @description
 */

public interface ProductInfoService {
    /**
     * 查询所有上架商品
     */
    List<ProductInfo> listUpProduct();

    List<ProductInfo> listProductByIds(List<String> ids);

    /**
     * 减库存
     * @param cartDTOS
     */
    void decreaseStock(List<CartDTO> cartDTOS);
}
