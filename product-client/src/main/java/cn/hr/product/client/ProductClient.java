package cn.hr.product.client;

import cn.hr.product.common.DecreaseStockInput;
import cn.hr.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @author fys2000
 * @date 2019/2/15 15:11
 * @description
 */
@FeignClient(name = "product")
public interface ProductClient {
    /**
     * 订单服务
     * @param ids
     * @return List<ProductInfoOutput>
     */
    @PostMapping("/product/listByIds")
    List<ProductInfoOutput> listProductByIds(@RequestBody List<String> ids);

    /**
     * 订单服务扣库存
     * @param decreaseStockInputs
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs);
}
