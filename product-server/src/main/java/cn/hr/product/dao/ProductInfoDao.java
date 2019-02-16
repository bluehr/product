package cn.hr.product.dao;

import cn.hr.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: fys2000
 * @Date: 2019/1/18 14:24
 * @Description:
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    /**
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
