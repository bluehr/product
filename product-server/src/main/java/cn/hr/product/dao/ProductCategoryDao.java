package cn.hr.product.dao;

import cn.hr.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/18 14:24
 * @description
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    /**
     * 查找所传入的类目
     * @param productCategoryTypes
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryTypes);
}
