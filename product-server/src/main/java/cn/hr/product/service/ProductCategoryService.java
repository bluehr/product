package cn.hr.product.service;

import cn.hr.product.entity.ProductCategory;

import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/25 10:36
 * @description
 */
public interface ProductCategoryService {
    /**
     * 查询分类
     * @param categories
     * @return
     */
    List<ProductCategory> getProductCatories(List<Integer> categories);
}
